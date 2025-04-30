package com.scaler.BookMyShowMorningJan25.Services;

import com.scaler.BookMyShowMorningJan25.Models.*;
import com.scaler.BookMyShowMorningJan25.Repositories.BookingRepository;
import com.scaler.BookMyShowMorningJan25.Repositories.ShowRepository;
import com.scaler.BookMyShowMorningJan25.Repositories.ShowSeatRepository;
import com.scaler.BookMyShowMorningJan25.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Type;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Optional;
@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private ShowRepository showRepository;
    @Autowired
    private ShowSeatRepository showSeatRepository;
    @Autowired
    private UserRepository userRepository;

    public Booking bookTickets(List<Long> showSeatIds, Long showId, Long userId){

        // userId is present - HW
        Optional<User> optionalUser = userRepository.findById(userId);
        if(optionalUser.isEmpty()){
            // If empty, then throw err
            throw new RuntimeException("User doesn't exist");
        }
        // showId is present
        Optional<Show> optionalShow = showRepository.findById(showId);
        if(optionalShow.isEmpty()){
            throw new RuntimeException("Show doesn't exist");
        }
        // reserve Seats logic
        List<ShowSeat> showSeats = reserveSeats(showSeatIds, showId);

        // HW: Calculate the amount from the show seats
        int amount = 1000;
        // Fetch all showSeatType by showId
        // Loop through all showSeats and check the type of that seat
        // and from the type match with showSeattype to get the price


        // create the booking object and set the required details
        Booking booking = new Booking();
        booking.setUser(optionalUser.get());
        booking.setShow(optionalShow.get());
        booking.setShowSeats(showSeats);
        booking.setAmount(amount);
        booking.setBookingStatus(BookingStatus.IN_PROGRESS);
        // save and return the booking object
        return bookingRepository.save(booking);
    }
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public List<ShowSeat> reserveSeats(List<Long> showSeatIds, Long showId){
        // ------------------Transaction starts -------------------
        // List of show seats is available or not
        for(Long showSeatId : showSeatIds){
            checkAvailability(showSeatId);
        }

        // if available:
        //       a. Update the status of all show seats to blocked
        //       b. Update the blockedAt time to current time

        List<ShowSeat> showSeats = showSeatRepository.findAllById(showSeatIds);
        for(ShowSeat showSeat : showSeats){
            if(showSeat.getShow().getId().equals(showId)){
                showSeat.setSeatStatus(SeatStatus.BLOCKED);
                showSeat.setBlockedAt(new Date());
            }
        }


        // Save those seats back to DB
        return showSeatRepository.saveAll(showSeats);

        // ------------------Transaction ends -------------------
    }
    public void checkAvailability(Long showSeatId){
        // if not available:
        //       a. throw err
        Optional<ShowSeat> showSeatOptional = showSeatRepository.findById(showSeatId);
        if(showSeatOptional.isEmpty()){
            throw new RuntimeException("Invalid show seat selected");
        }

        ShowSeat showSeat = showSeatOptional.get();

        if(showSeat.getSeatStatus().equals(SeatStatus.BOOKED)){
            throw new RuntimeException("Seats are already booked!");
        }

        if(showSeat.getSeatStatus().equals(SeatStatus.BLOCKED)){
            // Duration between currenttime and blocked time -> (currentTime - blockedTime)
            Long duration = Duration.between(new Date().toInstant(), showSeat.getBlockedAt().toInstant()).toMinutes();
            if(duration < 10){
                throw new RuntimeException("Seats are currently blocked!");
            }
        }
    }
}
