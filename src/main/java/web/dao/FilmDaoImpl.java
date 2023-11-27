package web.dao;

import org.springframework.stereotype.Repository;
import web.model.Film;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
@Repository
public class FilmDaoImpl implements FilmDao {
//    private static final AtomicInteger AUTO_ID = new AtomicInteger(0);
//    private static Map<Integer, Film> films = new HashMap<>();
//    static {
//        Film film1 = new Film();
//        film1.setId(AUTO_ID.getAndIncrement());
//        film1.setTitle("Inception");
//        film1.setYear(2010);
//        film1.setGenre("sci-fi");
//        film1.setWatched(true);
//        films.put(film1.getId(), film1);
//
//        Film film2 = new Film();
//        film2.setId(AUTO_ID.getAndIncrement());
//        film2.setTitle("Interstellar");
//        film2.setYear(2014);
//        film2.setGenre("Fantasy");
//        film2.setWatched(true);
//        films.put(film2.getId(), film2);
//    }
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Film> allFilms() {
        return entityManager.createQuery("FROM Film", Film.class).getResultList();
    }

    @Override
    public void add(Film film) {
//        film.setId(AUTO_ID.getAndIncrement());
//        films.put(film.getId(), film);
        entityManager.persist(film);
    }

    @Override
    public void delete(Film film) {
        entityManager.createQuery("DELETE FROM Film WHERE id = :id").setParameter("id", film.getId()).executeUpdate();
    }

    @Override
    public void edit(Film film) {
        entityManager.merge(film);
    }

    @Override
    public Film getById(int id) {
        return entityManager.find(Film.class, id);
    }
}
