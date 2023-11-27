package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.FilmDao;
import web.dao.FilmDaoImpl;
import web.model.Film;

import java.util.List;
@Service
public class FilmServiceImpl implements FilmService {
    @Autowired
    public void setFilmDao(FilmDao filmDao) {
        this.filmDao = filmDao;
    }
    //    private FilmDao filmDao = new FilmDaoImpl();
    FilmDao filmDao;
    @Transactional
    @Override
    public List<Film> allFilms() {
        return filmDao.allFilms();
    }

    @Override
    @Transactional
    public void add(Film film) {
        filmDao.add(film);
    }
    @Transactional
    @Override
    public void delete(Film film) {
        filmDao.delete(film);
    }
    @Transactional
    @Override
    public void edit(Film film) {
        filmDao.edit(film);
    }
    @Transactional
    @Override
    public Film getById(int id) {
        return filmDao.getById(id);
    }
}
