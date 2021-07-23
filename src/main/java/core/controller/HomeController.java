package core.controller;

import core.entity.Film;
import core.service.FilmService;
import core.service.FilmServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class HomeController {

    FilmService service;

    public void setService(FilmService service){
        this.service = service;
    }

    public FilmService getService() {
        return this.service;
    }

    @GetMapping("/home")
    public String home(Model model) {
        List<Film> films = service.listFilm();
        model.addAttribute("films", films);
        System.out.println("film:"+films);
        return "home";
    }

    @GetMapping("/addFilm")
    public String addFilm(Model model) {
        Film film = new Film();
        model.addAttribute("film", film);
        return "addFilm";
    }

    @PostMapping("/addFilm")
    public String saveFilm(Model model) {
        Film film = (Film) model.getAttribute("film");
        service.registerFilm(film);
        return "home";
    }

    @DeleteMapping("/removeFilm")
    public String removeFilm(Model model) {
        Film film = (Film) model.getAttribute("film");
        service.deleteFilm(film);
        return "home";
    }
}
