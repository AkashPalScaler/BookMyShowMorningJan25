package com.scaler.BookMyShowMorningJan25.Models;

import java.util.List;

public class Booking extends BaseModel{
    private List<Payment> payments;
    private int amount;
    private User user;
    private Show show;
    private List<ShowSeat> showSeats;
    private BookingStatus bookingStatus;
}
