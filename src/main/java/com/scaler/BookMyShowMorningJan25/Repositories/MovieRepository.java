package com.scaler.BookMyShowMorningJan25.Repositories;

import com.scaler.BookMyShowMorningJan25.Models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long>{
    Movie fetchByNameAndGenre(String name, String genre);
}
