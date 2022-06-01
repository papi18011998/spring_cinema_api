package com.cinema.cinema.dao;

import com.cinema.cinema.entities.Cinema;
import com.cinema.cinema.entities.Seance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeanceRepository extends JpaRepository<Seance,Long> {
}
