package com.cinema.cinema.dao;

import com.cinema.cinema.entities.Cinema;
import com.cinema.cinema.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket,Long> {
}
