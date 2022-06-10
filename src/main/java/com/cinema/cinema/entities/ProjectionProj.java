package com.cinema.cinema.entities;


import org.springframework.data.rest.core.config.Projection;

import java.util.Collection;
import java.util.Date;

@Projection(name = "projection",types = {com.cinema.cinema.entities.Projection.class})
public abstract interface ProjectionProj {
    public Long getId();
    public Date dateProjection();
    public double getPrix();
    public Salle getSalle();
    public Film getFilm();
    public Seance getSeance();
    public Collection<Ticket> getTickets();

}
