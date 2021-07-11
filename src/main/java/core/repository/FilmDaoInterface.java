package core.repository;

import core.entity.Film;

import java.util.List;

public interface FilmDaoInterface {
     void save(Film f);
     Film getById(int Id);
     List<Film> list();
}
