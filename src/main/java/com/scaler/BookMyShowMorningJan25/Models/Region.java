package com.scaler.BookMyShowMorningJan25.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Region extends BaseModel {
    private String name;
    private String city;
    // Region 1:m theatre
    @OneToMany
    private List<Theatre> theatres;
}
