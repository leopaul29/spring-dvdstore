package core;

import core.controller.DefaultFilmController;
import core.entity.Film;
import core.service.FilmService;

public class App1 {

    public static void main(String[] args) {
        DefaultFilmController controller = new DefaultFilmController();
        controller.registerFilmFromConsoleInput();
    }
}
