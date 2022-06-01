package com.cinema.cinema.dao;

import com.cinema.cinema.entities.Cinema;
import com.cinema.cinema.entities.Ville;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VilleRepository extends JpaRepository<Ville,Long> {
}
