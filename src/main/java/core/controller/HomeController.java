package core.controller;

import core.DVDStoreApp;
import core.entity.Film;
import core.service.FilmService;
import core.service.FilmServiceInterface;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class HomeController {
    private static final Logger log = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    FilmService service;

    // home
    @GetMapping(path = {"/", "/home"})
    public String home(Model model) {
        List<Film> films = service.listFilmBorrowable();
        model.addAttribute("films", films);
        return "home";
    }

    // openFilm
    @GetMapping("/openFilm")
    public String openFilm(@RequestParam(name="filmId", required=true) Long filmId, Model model) {
        Film film = service.getFilmById(filmId);
        model.addAttribute("film", film);
        return "openFilm";
    }

    // addFilm
    @GetMapping("/addFilm")
    public String addFilm(Model model) {
        Film film = new Film();
        model.addAttribute("film", film);
        return "addFilm";
    }

    @PostMapping("/addFilm")
    public String postAddFilm(@ModelAttribute Film film) {
        System.out.println("postAddFilm: "+film);
        service.registerFilm(film);
        return "redirect:/home/";
    }

    // editFilm
    @GetMapping("/editFilm")
    public String editFilm(@RequestParam(name="filmId", required=true) Long filmId, Model model) {
        Film film = service.getFilmById(filmId);
        model.addAttribute("film", film);
        return "editFilm";
    }

    @PostMapping("/editFilm")
    public String postEditFilm(@ModelAttribute Film film) {
        service.registerFilm(film);
        return "redirect:/home/";
    }

    // borrowFilm
    @GetMapping("/borrowFilm")
    public String borrowFilm(@RequestParam(name="filmId", required=true) Long filmId) {
        service.borrowFilm(filmId);
        return "redirect:/home";
    }

    // deleteFilm
    @GetMapping("/deleteFilm")
    public String removeFilm(@RequestParam(name="filmId", required=true) Long filmId) {
        Film filmById = service.getFilmById(filmId);
        service.deleteFilm(filmById);
        return "redirect:/home";
    }
}
