package com.scaler.BookMyShowMorningJan25.Repositories;

import com.scaler.BookMyShowMorningJan25.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
