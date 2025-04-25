package com.scaler.BookMyShowMorningJan25.Models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class SeatType extends BaseModel{
    private String type;
}
