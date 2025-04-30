package com.scaler.BookMyShowMorningJan25.Services;

import com.scaler.BookMyShowMorningJan25.Models.User;
import com.scaler.BookMyShowMorningJan25.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User signup(String email, String password){
        // First check if user with this email exists
        Optional<User> optionalUser = userRepository.findByEmail(email);
        if(optionalUser.isPresent()){
            // If yes, then throw err
            throw new RuntimeException("User with email already exists");
        }
        // If no, then create the user and insert in DB
        User user = new User();
        user.setName("Akash");
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        user.setEmail(email);
        user.setPassword(bCryptPasswordEncoder.encode(password));



        return userRepository.save(user);
    }

    // HW: Login
    // First check if email exists - if not -return user doesn't exist
    // Match password // bCryptPasswordEncoder.matches(password, user.getPassword());
}
