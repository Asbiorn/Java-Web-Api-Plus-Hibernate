package org.moviemoviesapi.services;


import org.moviecharactersapi.repositories.MovieRepository;
import org.moviecharactersapi.services.MovieService;
import org.moviecharactersapi.models.Movie;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class MovieServiceImpl implements MovieService {
    private final MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public Movie findById(Integer id) {
        return movieRepository.findById(id).get();
    }

    @Override
    public Collection<Movie> findAll() {
        return movieRepository.findAll();
    }

    @Override
    public Movie add(Movie entity) {
        return movieRepository.save(entity);
    }

    @Override
    public Movie update(Movie entity) {
        return movieRepository.save(entity);
    }

    @Override
    public void deleteById(Integer id) {
/*        Movie movie = findById(id);
        if(movie.getMovies()!= null) // if the movie has movies linked to it
            movie.getMovies().forEach(movie -> movie.setMovie(null)); // movie.getMovies().setMovie(null); remove relations, from the side which owns it.
   */
    movieRepository.deleteById(id);
    }

    @Override
    public boolean exists(Integer integer) {
        return false;
    }

}
