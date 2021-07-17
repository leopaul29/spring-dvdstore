package core.repository;

import core.entity.Film;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmRepository extends CrudRepository<Film, Long> {

    List<Film> findByTitre(String titre);

    Film findById(long id);
}
