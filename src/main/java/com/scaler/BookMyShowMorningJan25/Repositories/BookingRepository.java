package com.scaler.BookMyShowMorningJan25.Repositories;

import com.scaler.BookMyShowMorningJan25.Models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
}
