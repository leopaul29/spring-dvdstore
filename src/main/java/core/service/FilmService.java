package core.service;

import core.entity.Film;
import core.repository.FileFilmDao;
import core.repository.FilmDaoInterface;

public class FilmService {
    FilmDaoInterface dao;

    public FilmDaoInterface getDao() {
        return dao;
    }

    public void setDao(FilmDaoInterface dao) {
        this.dao = dao;
    }

    public void registerFilm(Film film){
        dao.save(film);
    }
}
