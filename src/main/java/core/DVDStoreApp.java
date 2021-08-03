package core;

import core.entity.Film;
import core.repository.FilmRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DVDStoreApp {
    private static final Logger log = LoggerFactory.getLogger(DVDStoreApp.class);

    public static void main(String[] args) {
        SpringApplication.run(DVDStoreApp.class, args);
    }

    @Bean
    public CommandLineRunner demo(FilmRepository repository) {
        return (args) -> {
            // save a few films
            repository.save(new Film("The Tomorrow War", "Action, Adventure, Drama", "Un père de famille est appelé à combattre dans une guerre future où le sort de l'humanité dépend de sa capacité à affronter le passé.", 1));
            repository.save(new Film("Black Widow", "Action, Adventure, Sci-Fi", "Natasha Romanoff confronts the darker parts of her ledger when a dangerous conspiracy with ties to her past arises.", 3));
            repository.save(new Film("Tenet", "Action, Sci-Fi, Thriller", "Armed with only one word, Tenet, and fighting for the survival of the entire world, a Protagonist journeys through a twilight world of international espionage on a mission that will unfold in something beyond real time.", 3));
            repository.save(new Film("Nobody", "Action, Crime, Drama", "A bystander who intervenes to help a woman being harassed by a group of men becomes the target of a vengeful drug lord.", 2));
            repository.save(new Film("Mortal Kombat", "Action, Adventure, Fantasy", "MMA fighter Cole Young seeks out Earth's greatest champions in order to stand against the enemies of Outworld in a high stakes battle for the universe.", 1));
            repository.save(new Film("Luca", "Animation, Adventure, Comedy", "On the Italian Riviera, an unlikely but strong friendship grows between a human being and a sea monster disguised as a human.", 2));

/*
            // fetch all films
            log.info("Films found with findAll():");
            log.info("-------------------------------");
            for (Film film : repository.findAll()) {
                log.info(film.toString());
            }
            log.info("");

            // fetch an individual film by ID
            Film film = repository.findById(1L);
            log.info("Film found with findById(1L):");
            log.info("--------------------------------");
            log.info(film.toString());
            log.info("");

            // fetch films by last name
            log.info("Film found with findByTitre('Nobody'):");
            log.info("--------------------------------------------");
            repository.findByTitre("Nobody").forEach(Nobody -> {
                log.info(Nobody.toString());
            });
            // for (Film Nobody : repository.findByTitre("Nobody")) {
            //  log.info(Nobody.toString());
            // }
            log.info("");*/
        };
    }
}
