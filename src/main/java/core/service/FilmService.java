package core.service;

import core.entity.Film;
import core.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FilmService {

    @Autowired
    FilmRepository repository;

    public void registerFilm(Film film){
        repository.save(film);
    }

    public Film getFilmById(Long id) {
        return repository.findById(id).get();
    }

    public List<Film> listFilm(){
        return (List<Film>) repository.findAll();
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
