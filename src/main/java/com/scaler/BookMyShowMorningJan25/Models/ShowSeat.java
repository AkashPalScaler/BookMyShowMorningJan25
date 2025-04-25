package com.scaler.BookMyShowMorningJan25.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
public class ShowSeat extends BaseModel {
    // ShowSeat : Show
    @ManyToOne
    private Show show;
    // ShowSeat M:1 Seat
    @ManyToOne
    private  Seat seat; // seatType
    @Enumerated(EnumType.ORDINAL)
    private SeatStatus seatStatus;
}


// Show seat represents virtual seat you are booking, but 1 physical can be in many shows
// ShowSeat : Seat
// 11AM_H1  :  H1
// 11AM_H2  :  H2
// 12AM_H1  :  H1
// 12AM_H2  :  H2

