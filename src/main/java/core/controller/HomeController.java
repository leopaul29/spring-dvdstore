package core.controller;

import core.entity.Film;
import core.service.FilmService;
import core.service.FilmServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
        return "home";
    }
}