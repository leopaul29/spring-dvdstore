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
    @Autowired
    FilmRepository dao;

//    public FilmDaoInterface getDao() {
//        return dao;
//    }
//
//    public void setDao(FilmDaoInterface dao) {
//        this.dao = dao;
//    }

    public void registerFilm(Film film){
        dao.save(film);
    }

    public List<Film> listFilm(){
        return (List<Film>) dao.findAll();
    }
}
