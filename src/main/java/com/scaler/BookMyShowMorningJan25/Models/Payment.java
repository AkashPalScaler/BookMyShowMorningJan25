package com.scaler.BookMyShowMorningJan25.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Payment extends  BaseModel{
    private int amount;
    private String reference;
    @Enumerated(EnumType.ORDINAL)
    private PaymentType paymentType;
    @Enumerated(EnumType.ORDINAL)
    private PaymentStatus paymentStatus;
    //Payment M:1 Booking
    @ManyToOne
    private Booking booking;
}
