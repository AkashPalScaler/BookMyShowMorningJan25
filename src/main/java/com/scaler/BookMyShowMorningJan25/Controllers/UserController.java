package com.scaler.BookMyShowMorningJan25.Controllers;

import com.scaler.BookMyShowMorningJan25.DTOs.ResponseStatus;
import com.scaler.BookMyShowMorningJan25.DTOs.SignUpRequestDTO;
import com.scaler.BookMyShowMorningJan25.DTOs.SignUpResponseDTO;
import com.scaler.BookMyShowMorningJan25.Models.User;
import com.scaler.BookMyShowMorningJan25.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    public SignUpResponseDTO signup(SignUpRequestDTO signUpRequestDTO){
        SignUpResponseDTO signUpResponseDTO = new SignUpResponseDTO();
        try{
            // Destructuring the input
            User user = userService.signup(signUpRequestDTO.getEmail(), signUpRequestDTO.getPassword());

            // Format the output
            signUpResponseDTO.setUserId(user.getId());
            signUpResponseDTO.setMessage("User is successfully signed up");
            signUpResponseDTO.setResponseStatus(ResponseStatus.SUCCESS);
            return signUpResponseDTO;
        }catch(Exception e){
            System.out.println("Error in Signup : " + e.getMessage());
            signUpResponseDTO.setMessage(e.getMessage());
            signUpResponseDTO.setResponseStatus(ResponseStatus.FAILURE);
            return signUpResponseDTO;
        }
    }
}
