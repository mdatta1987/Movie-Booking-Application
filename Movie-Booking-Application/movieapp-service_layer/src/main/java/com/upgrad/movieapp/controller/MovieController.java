package com.upgrad.movieapp.controller;

import com.upgrad.movieapp.dto.MovieDTO;
import com.upgrad.movieapp.entities.Movie;
import com.upgrad.movieapp.services.MovieService;
import java.util.ArrayList;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping(value="/movie_app/v1")
public class MovieController {

  @Autowired
  private MovieService movieService ;

  @Autowired
  ModelMapper modelMapper;

  /**
   * Method for creating movies
   * 127.0.0.1:8080/movie_app/v1/movies
   */

  @PostMapping(value="/movies", consumes = MediaType.APPLICATION_JSON_VALUE,
  produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity createMovie(MovieDTO movieDTO){

    //convert movieDTO to MovieEntity

     Movie newMovie = modelMapper.map(movieDTO, Movie.class);
     Movie savedMovie = movieService.acceptMovieDetails(newMovie);

     MovieDTO savedMovieDto = modelMapper.map(savedMovie,MovieDTO.class);

     return new ResponseEntity(savedMovieDto, HttpStatus.CREATED);

  }

  @GetMapping(value = "/movies" , consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity getAllMovies(){
    List<Movie> movieList = movieService.getAllMovies();
    List<MovieDTO> movieDTOList = new ArrayList<>();

    for(Movie movie : movieList){
      movieDTOList.add(modelMapper.map(movie, MovieDTO.class));
    }
    return new ResponseEntity(movieDTOList, HttpStatus.OK);
  }
  @GetMapping(value="/movies/{id}")
  public ResponseEntity getMovieBasedOnId(@PathVariable(name="id") int id){
    Movie responseMovie = movieService.getMovieDetails(id);

    MovieDTO responseMovieDTO = modelMapper.map(responseMovie, MovieDTO.class);

    return new ResponseEntity(responseMovieDTO, HttpStatus.OK);
  }

  @PutMapping( value= "movies/{id}" ,consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity updateMovieDetails(@PathVariable(name ="id") int id,
      @RequestBody MovieDTO movieDTO){

    Movie newMovie = modelMapper.map(movieDTO, Movie.class);
    Movie udpatedMovie = movieService.updateMovieDetails(id, newMovie);

    MovieDTO updatedMovieDTO = modelMapper.map(udpatedMovie, MovieDTO.class);

    return new ResponseEntity(updatedMovieDTO, HttpStatus.OK) ;
  }
}
