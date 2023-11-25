package web.dao;

import web.model.Film;

import java.util.List;

public interface FilmDao {
    List<Film> allFilms();
    void add(Film film);
    void delete(Film film);
    void edit(Film film);
    Film getById(int id);
}
