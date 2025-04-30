package com.scaler.BookMyShowMorningJan25.Repositories;

import com.scaler.BookMyShowMorningJan25.Models.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowRepository extends JpaRepository<Show, Long> {
}
