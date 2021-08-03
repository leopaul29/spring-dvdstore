package core.service;

import core.entity.Film;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface FilmServiceInterface {
    public void registerFilm(Film film);
    public Film getFilmById(Long id);
    public List<Film> listFilm();
    public List<Film> listFilmBorrowable();
}
