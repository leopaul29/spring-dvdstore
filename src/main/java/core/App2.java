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
public class App2 {

    private static final Logger log = LoggerFactory.getLogger(DVDStoreApp.class);

    public static void main(String[] args) {
        SpringApplication.run(DVDStoreApp.class);
    }

    @Bean
    public CommandLineRunner demo(FilmRepository repository) {
        return (args) -> {
            // save a few customers
            repository.save(new Film("Jack", "Bauer"));
            repository.save(new Film("Chloe", "O'Brian"));
            repository.save(new Film("Kim", "Bauer"));
            repository.save(new Film("David", "Palmer"));
            repository.save(new Film("Michelle", "Dessler"));

            // fetch all customers
            log.info("Customers found with findAll():");
            log.info("-------------------------------");
            for (Film film : repository.findAll()) {
                log.info(film.toString());
            }
            log.info("");

            // fetch an individual customer by ID
            Film film = repository.findById(1L);
            log.info("Customer found with findById(1L):");
            log.info("--------------------------------");
            log.info(film.toString());
            log.info("");

            // fetch customers by last name
            log.info("Customer found with findByLastName('Bauer'):");
            log.info("--------------------------------------------");
            repository.findByTitre("Bauer").forEach(bauer -> {
                log.info(bauer.toString());
            });
            // for (Customer bauer : repository.findByLastName("Bauer")) {
            //  log.info(bauer.toString());
            // }
            log.info("");
        };
    }
}
