package com.scaler.BookMyShowMorningJan25.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Booking extends BaseModel{
    // Booking 1:M Payments
    @OneToMany
    private List<Payment> payments;
    private int amount;
    @ManyToOne
    private User user;
    // Booking M:1 Show
    @ManyToOne
    private Show show;
    // Booking 1:M showSeats
    @OneToMany
    private List<ShowSeat> showSeats; // The seats of one/that show
    @Enumerated(EnumType.ORDINAL)
    private BookingStatus bookingStatus;
}

// bookingStatus : id | value -> Springboot doesn't by default create this(enum) table
// booking : id | amount | user_id | show_id | booking_status
// Enumtype:STRING  1 | 1239  | 98123624 | 12 |  IN_PROGRESS
// Enumtype:ORDINAL 1 | 1239  | 98123624 | 12 |  0

// Booking b = //ORM
// b.bookingStatus
