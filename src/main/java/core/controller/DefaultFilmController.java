package core.controller;

import core.entity.Film;
import core.service.FilmService;
import core.service.FilmServiceInterface;

import java.util.Scanner;

public class DefaultFilmController {
    FilmServiceInterface service;

    public FilmServiceInterface getService() {
        return service;
    }

    public void setService(FilmServiceInterface service) {
        this.service = service;
    }

    public void registerFilmFromConsoleInput() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Titre?");
        String titre = sc.nextLine();
        System.out.println("Genre?");
        String genre = sc.nextLine();
        System.out.println("NbExemplaire?");
        int NbExemplaire = sc.nextInt();

        Film f= new Film();
        f.setTitre(titre);
        f.setGenre(genre);
        f.setNbExemplaires(NbExemplaire);

        service.registerFilm(f);
    }
}
