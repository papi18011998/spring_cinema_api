package com.cinema.cinema.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titre, realisateur,description,photo;
    private double duree;
    private Date dateSortie;
    @OneToMany(mappedBy = "film")
    //@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Collection<Projection> projections;
    @ManyToOne()
    private Categorie categorie;

}
