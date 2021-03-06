package core.repository;

import core.entity.Film;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmRepository extends CrudRepository<Film, Long> {

    Film findByTitre(String titre);

    Film findById(long id);
}
