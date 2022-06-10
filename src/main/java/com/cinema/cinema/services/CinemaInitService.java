package com.cinema.cinema.services;

import com.cinema.cinema.dao.*;
import com.cinema.cinema.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

@Service
@Transactional
public class CinemaInitService implements ICinemaInitService{
    @Autowired
    private VilleRepository villeRepository;
    @Override
    public void initVilles() {
        Stream.of("Dakar","Tambacounda","Rufisque","Casablanca","Rabat").forEach(nameVille->{
           Ville ville = new Ville();
              ville.setNom(nameVille);
              villeRepository.save(ville);

        });
    }
    @Autowired
    private CinemaRepository cinemaRepository;
    @Override
    public void initCinemas() {
        villeRepository.findAll().forEach(ville -> {
            Stream.of("THIAROYE","FOUNOUD","CHARAZAD","DAOULIZ","GRAND THEATRE","INSTITU FRANCAIS").forEach(cinemaName->{
                Cinema cinema = new Cinema();
                cinema.setNom(cinemaName);
                cinema.setVille(ville);
                cinema.setNombreSalles(10+(int) (Math.random()*17));
                cinemaRepository.save(cinema);
            });
        });
    }
    @Autowired
    private SalleRepository salleRepository;
    @Override
    public void initSalles() {
        cinemaRepository.findAll().forEach(cinema -> {
            for (int i=1; i<cinema.getNombreSalles();i++){
                Salle salle = new Salle();
                salle.setNombrePlaces(20+(int) (Math.random()*30));
                salle.setCinema(cinema);
                salle.setNom("Salle "+cinema.getNom());
                salleRepository.save(salle);
            }
        });
    }
    @Autowired
    SeanceRepository seanceRepository;
    @Override
    public void initSeances() {
        DateFormat df = new SimpleDateFormat("HH:mm");
        Stream.of("12:00","15:00","17:00","19:00","21:00","23:00").forEach(s->{
            Seance seance = new Seance();
            try {
                seance.setHeureDebut(df.parse(s));
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            seanceRepository.save(seance);
        });
    }
    @Autowired
    PlaceRepository placeRepository;
    @Override
    public void initPlaces() {
        salleRepository.findAll().forEach(salle -> {
            for (int i = 0; i < salle.getNombrePlaces(); i++) {
                Place place = new Place();
                place.setNumero(i+1);
                place.setSalle(salle);
                placeRepository.save(place);
            }
        });
    }
    @Autowired
    CategorieRepository categorieRepository;
    @Override
    public void initCategories() {
        Stream.of("Drame","Action","Comedie","Fiction","Histoire","Romance").forEach(categorieName->{
            Categorie categorie = new Categorie();
            categorie.setNom(categorieName);
            categorieRepository.save(categorie);
        });
    }
    @Autowired
    FilmRepository filmRepository;
    @Override
    public void initFilms() {
        double [] durees = new double[]{1,1.5,3.4,2,1.3};
        List<Categorie> categories = categorieRepository.findAll();
            Stream.of("Game of Thrones","Spiderman","Iron Man","Captain America","Un homme en colere","Harry Potter","La ligne verte","Ant Man").forEach(filmName->{
                  Film film = new Film();
                  film.setTitre(filmName);
                  film.setDescription(filmName);
                  film.setDuree(durees[new Random().nextInt(durees.length)]);
                  film.setPhoto("https://via.placeholder.com/600/8f209a");
                  film.setCategorie(categories.get(new Random().nextInt(categories.size())));
                  filmRepository.save(film);
            });
    }
    @Autowired
    ProjectionRepository projectionRepository;
    @Override
    public void initProjections() {
        double[] prix = new  double[]{1200,1244.3,45000};
    villeRepository.findAll().forEach(ville->{
        ville.getCinemas().forEach(cinema->{
            cinema.getSalles().forEach(salle -> {
                filmRepository.findAll().forEach(film -> {
                    seanceRepository.findAll().forEach(seance -> {
                        Projection projection = new Projection();
                        projection.setDateProjection(new Date());
                        projection.setFilm(film);
                        projection.setPrix(new Random().nextInt(prix.length));
                        projection.setSalle(salle);
                        projection.setSeance(seance);
                        projectionRepository.save(projection);
                    });
                });
            });
        });
    });
    }
    @Autowired
    TicketRepository ticketRepository;
    @Override
    public void initTickets() {
        projectionRepository.findAll().forEach(p->{
            p.getSalle().getPlaces().forEach(place -> {
                Ticket ticket = new Ticket();
                ticket.setPrix(p.getPrix());
                ticket.set_reserved(false);
                ticket.setPlace(place);
                ticket.setProjection(p);
                ticketRepository.save(ticket);
            });
        });
    }
}
