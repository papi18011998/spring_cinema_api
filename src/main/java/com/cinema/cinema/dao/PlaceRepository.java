package com.cinema.cinema.dao;

import com.cinema.cinema.entities.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaceRepository extends JpaRepository<Cinema,Long> {
}
