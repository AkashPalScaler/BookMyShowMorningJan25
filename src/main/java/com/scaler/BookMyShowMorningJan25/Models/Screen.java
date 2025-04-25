package com.scaler.BookMyShowMorningJan25.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Screen extends BaseModel{
    private String name;
    @Enumerated(EnumType.ORDINAL)
    @ElementCollection
    private List<Feature> features;
    // Screen 1:M Seat
    @OneToMany
    private List<Seat> seats;
    // Screen M:1 theatre
    @ManyToOne
    private Theatre theatre;
}
