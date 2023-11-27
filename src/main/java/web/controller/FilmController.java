package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.ModelMap;
import web.model.Film;
import web.service.FilmService;
import web.service.FilmServiceImpl;

import java.util.List;

@Controller
@RequestMapping
public class FilmController {
//    private static  Film film;
//    static {
//        film = new Film();
//        film.setTitle("Interstellar");
//        film.setYear(2014);
//        film.setGenre("Fantasy");
//        film.setWatched(true);
//
//    }
    @Autowired
    public void setFilmService(FilmService filmService) {
        this.filmService = filmService;
    }

    private FilmService filmService;

    @RequestMapping(value = "/films", method = RequestMethod.GET)
    public ModelAndView allFilms() {
        List<Film> films = filmService.allFilms();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("films");
        modelAndView.addObject("filmsList", films);
        return modelAndView;
    }

    @GetMapping(value = "/films/edit")
    public String editPage(@RequestParam("id") int id, ModelMap model) {
        model.addAttribute("film", filmService.getById(id));
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("editPage");
        return "editPage";
    }
    @PostMapping(value = "/films/edit")
    public String editSubmit(@ModelAttribute Film film) {
        filmService.edit(film);
        return "redirect:/films";

    }

    //страница добавления фильма
    @GetMapping(value = "/films/add")
    public String addPage(ModelMap model) {
        model.addAttribute("film", new Film());
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("editPage");
        return "addPage";
    }
    //метод добавление фильма
    @PostMapping(value = "/films/add")
    public String addFilm(@ModelAttribute Film film) {
        filmService.add(film);
        return "redirect:/films";

    }
    @GetMapping(value = "/films/delete")
    public String deleteFilm(@RequestParam("id") int id) {
        Film film = filmService.getById(id);
        filmService.delete(film);
        return "redirect:/films";
    }
}