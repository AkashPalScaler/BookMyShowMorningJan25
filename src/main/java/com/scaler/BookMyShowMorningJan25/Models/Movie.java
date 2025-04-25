package com.scaler.BookMyShowMorningJan25.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Movie extends  BaseModel {
    private String name;
    private String genre;
    private int run_time_mins;

    @ElementCollection
    private List<String> actors;

    @Enumerated(EnumType.ORDINAL)
    @ElementCollection
    private List<Language> languages;

    }

    // movie_actor : id | movie_id | actor