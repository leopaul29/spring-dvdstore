package core.repository;

import core.entity.Film;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FilmRepository  extends CrudRepository<Film, Long> {

    List<Film> findByTitre(String titre);

    Film findById(long id);
}
