package com.upgrad.movieapp.services;

import com.upgrad.movieapp.entities.Movie;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface MovieService {

  public Movie acceptMovieDetails(Movie movie);

  public List<Movie> acceptMultipleMovieDetails(List<Movie> movies);

  public Movie getMovieDetails(int id);

  public Movie updateMovieDetails(int id , Movie movie);

  public boolean deleteMovie(int id);

  public List<Movie> getAllMovies();

  public Page<Movie> getPaginatedMovieDeatails(Pageable pageable);
}
