package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import web.model.Film;

@Controller
public class FilmController {
    private static  Film film;
    static {
        film = new Film();
        film.setTitle("Interstellar");
        film.setYear(2014);
        film.setGenre("Fantasy");
        film.setWatched(true);

    }

    @RequestMapping(value = "/films", method = RequestMethod.GET)
    public ModelAndView allFilms() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("films");
        modelAndView.addObject(film);
        return modelAndView;
    }

    @RequestMapping(value = "/films/edit", method = RequestMethod.GET)
    public ModelAndView editPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editPage");
        return modelAndView;
    }
}