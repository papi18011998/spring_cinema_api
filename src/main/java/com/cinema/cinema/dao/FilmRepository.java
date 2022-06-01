package com.cinema.cinema.dao;

import com.cinema.cinema.entities.Cinema;
import com.cinema.cinema.entities.Film;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<Film,Long> {
}
