package com.scaler.BookMyShowMorningJan25;

import com.scaler.BookMyShowMorningJan25.Controllers.UserController;
import com.scaler.BookMyShowMorningJan25.DTOs.SignUpRequestDTO;
import com.scaler.BookMyShowMorningJan25.DTOs.SignUpResponseDTO;
import com.scaler.BookMyShowMorningJan25.Models.BaseModel;
import com.scaler.BookMyShowMorningJan25.Models.Language;
import com.scaler.BookMyShowMorningJan25.Models.Movie;
import com.scaler.BookMyShowMorningJan25.Models.User;
import com.scaler.BookMyShowMorningJan25.Repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class BookMyShowMorningJan25Application implements CommandLineRunner {
    @Autowired
	private UserController userController;
	@Autowired
	private MovieRepository movieRepository;

	public static void main(String[] args) {
		SpringApplication.run(BookMyShowMorningJan25Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		SignUpRequestDTO signUpRequestDTO = new SignUpRequestDTO();
//		signUpRequestDTO.setEmail("akash.pal2@gmail.com");
//		signUpRequestDTO.setPassword("passpass");
//
//		SignUpResponseDTO signUpResponseDTO = userController.signup(signUpRequestDTO);
//
//		System.out.println(signUpResponseDTO.getMessage());
//		// Add all the data
//
//		Movie movie = new Movie();
//		movie.setName("Kalki");
//		movie.setActors(new ArrayList<>());
//		movie.setGenre("Fiction");
//		movie.setRun_time_mins(100);
//		movie.setLanguages(List.of(Language.ENGLISH, Language.TAMIL, Language.HINDI));
//
//		movieRepository.save(movie);

		Movie newmovie = movieRepository.fetchByNameAndGenre("Kalki", "Fiction");
		System.out.println(newmovie.getName());
	}
}
