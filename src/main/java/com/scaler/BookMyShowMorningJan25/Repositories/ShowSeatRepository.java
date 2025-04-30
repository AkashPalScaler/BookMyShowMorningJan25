package com.scaler.BookMyShowMorningJan25.Repositories;

import com.scaler.BookMyShowMorningJan25.Models.Show;
import com.scaler.BookMyShowMorningJan25.Models.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowSeatRepository extends JpaRepository<ShowSeat, Long> {
}
