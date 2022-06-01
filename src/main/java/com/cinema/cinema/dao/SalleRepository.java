package com.cinema.cinema.dao;

import com.cinema.cinema.entities.Cinema;
import com.cinema.cinema.entities.Salle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalleRepository extends JpaRepository<Salle,Long> {
}
