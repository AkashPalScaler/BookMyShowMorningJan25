package com.scaler.BookMyShowMorningJan25.Controllers;

import com.scaler.BookMyShowMorningJan25.DTOs.BookingRequestDTO;
import com.scaler.BookMyShowMorningJan25.DTOs.BookingResponseDTO;
import com.scaler.BookMyShowMorningJan25.DTOs.ResponseStatus;
import com.scaler.BookMyShowMorningJan25.Models.Booking;
import com.scaler.BookMyShowMorningJan25.Services.BookingService;
import com.scaler.BookMyShowMorningJan25.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BookingController {
    @Autowired
    private BookingService bookingService;
    public BookingResponseDTO bookShowSeats(BookingRequestDTO bookingRequestDTO){
       BookingResponseDTO bookingResponseDTO = new BookingResponseDTO();
       try{
           // UserService.login - userId
           Booking booking = bookingService.bookTickets(bookingRequestDTO.getShowSeatIds(), bookingRequestDTO.getShowId(), bookingRequestDTO.getUserId());

           bookingResponseDTO.setBookingId(bookingResponseDTO.getBookingId());
           bookingResponseDTO.setMessage("Booking was successfull");
           bookingResponseDTO.setResponseStatus(ResponseStatus.SUCCESS);
           return bookingResponseDTO;
       }catch(Exception e){
           System.out.println("Error in booking :" + e.getMessage());
           bookingResponseDTO.setMessage(e.getMessage());
           bookingResponseDTO.setResponseStatus(ResponseStatus.FAILURE);
           return bookingResponseDTO;
       }
    }
}
