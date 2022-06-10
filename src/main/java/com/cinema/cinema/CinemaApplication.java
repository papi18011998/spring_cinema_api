package com.cinema.cinema;

import com.cinema.cinema.services.ICinemaInitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableWebMvc
public class CinemaApplication implements CommandLineRunner {
    @Autowired
    private ICinemaInitService cinemaInitService;
    public static void main(String[] args) {
        SpringApplication.run(CinemaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//    cinemaInitService.initVilles();
//    cinemaInitService.initCinemas();
//    cinemaInitService.initSalles();
//    cinemaInitService.initPlaces();
//    cinemaInitService.initSeances();
//    cinemaInitService.initCategories();
//    cinemaInitService.initFilms();
//    cinemaInitService.initProjections();
//    cinemaInitService.initTickets();
    }
}
