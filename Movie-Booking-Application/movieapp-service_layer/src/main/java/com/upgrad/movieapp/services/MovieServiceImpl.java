package com.upgrad.movieapp.services;

import com.upgrad.movieapp.dao.MovieDao;
import com.upgrad.movieapp.entities.Movie;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class MovieServiceImpl implements MovieService{


  @Autowired
  private MovieDao movieDao ;

  @Override
  public Movie acceptMovieDetails(Movie movie) {
    return movieDao.save(movie);
  }

  @Override
  public List<Movie> acceptMultipleMovieDetails(List<Movie> movies) {
    List<Movie> savedMovies = new ArrayList<>();
    for(Movie movie : movies){
      savedMovies.add(acceptMovieDetails(movie));
    }
    return savedMovies;
  }

  @Override
  public Movie getMovieDetails(int id) {
    return movieDao.findById(id).get();
  }

  @Override
  public Movie updateMovieDetails(int id, Movie movie) {
    Movie savedMovie = getMovieDetails(id);
    savedMovie.setDuration(movie.getDuration());
    savedMovie.setTrailerUrl(movie.getTrailerUrl());
    savedMovie.setCoverPhotoUrl(movie.getCoverPhotoUrl());
    savedMovie.setReleaseDate(movie.getReleaseDate());
    savedMovie.setMovieName(movie.getMovieName());
    savedMovie.setMovieDescription(movie.getMovieDescription());

    movieDao.save(savedMovie);

    return savedMovie;
  }

  @Override
  public boolean deleteMovie(int id) {
    Movie savedMovie = getMovieDetails(id);

    if(savedMovie == null){
      return false ;
    }

    movieDao.delete(savedMovie);
    return true;
  }

  @Override
  public List<Movie> getAllMovies() {
    return movieDao.findAll();
  }

  @Override
  public Page<Movie> getPaginatedMovieDeatails(Pageable pageable) {
    return movieDao.findAll(pageable);
  }
}
