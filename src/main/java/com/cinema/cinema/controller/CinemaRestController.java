package com.cinema.cinema.controller;

import com.cinema.cinema.dao.FilmRepository;
import com.cinema.cinema.dao.TicketRepository;
import com.cinema.cinema.entities.Film;
import com.cinema.cinema.entities.Ticket;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
public class CinemaRestController {
    @Autowired
    private FilmRepository filmRepository;
    @Autowired
    private TicketRepository ticketRepository;
    @GetMapping(path="/images/{id}",produces = MediaType.IMAGE_JPEG_VALUE)
    public String getImage(@PathVariable(name = "id") Long id){
        Film film = filmRepository.findById(id).get();
        String photo = film.getPhoto();
        return photo;
    }

    @PostMapping("payerTickets")
    public List<Ticket> payerTicket(@RequestBody TicketForm ticketForm){
        List<Ticket> tickets = new ArrayList<>();
        ticketForm.getTickets().forEach(idTicket->{
            Ticket ticket = ticketRepository.findById(idTicket).get();
           ticket.setNomClient(ticketForm.getNomClient());
           ticket.set_reserved(true);
           ticketRepository.save(ticket);
              tickets.add(ticket);
        });
    return tickets;
    }
}
@Data
class TicketForm {
    private String nomClient;
    private List<Long> tickets = new ArrayList<>();
}
