package core.service;

import core.entity.Film;
import core.repository.FileFilmDao;
import core.repository.FilmDaoInterface;
import core.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmService {

    FilmRepository dao;

    public FilmRepository getDao() {
        return dao;
    }

    public void setDao(FilmRepository dao) {
        this.dao = dao;
    }

    public void registerFilm(Film film){
        dao.save(film);
    }

    public List<Film> listFilm(){
        return (List<Film>) dao.findAll();
    }

    public void deleteFilm(Film film) {
        dao.delete(film);
    }
}
