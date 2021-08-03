package core.service;

import core.controller.HomeController;
import core.entity.Film;
import core.repository.FilmRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FilmService implements FilmServiceInterface{
    private static final Logger log = LoggerFactory.getLogger(FilmService.class);

    @Autowired
    FilmRepository repository;

    @Override
    public void registerFilm(Film film){
        repository.save(film);
    }

    @Override
    public Film getFilmById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public List<Film> listFilm(){
        return (List<Film>) repository.findAll();
    }

    @Override
    public List<Film> listFilmBorrowable() {
        List<Film> all = (List<Film>) repository.findAll();
        return all.stream().filter(f -> f.getNbExemplaires()>0).collect(Collectors.toList());
    }

    public void deleteFilm(Film film) {
        repository.delete(film);
    }

    public void borrowFilm(Long id) {
        Film film = null;
        Optional<Film> optionalFilm = repository.findById(id);
        if(optionalFilm.isPresent()){
            film = optionalFilm.get();
            int nbExemplaires = film.getNbExemplaires();
            if(nbExemplaires>0) {
                nbExemplaires--;
                film.setNbExemplaires(nbExemplaires);
                repository.save(film);
            }
            return;
        }
    }
}
