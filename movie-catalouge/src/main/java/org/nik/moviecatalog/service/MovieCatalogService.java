package org.nik.moviecatalog.service;

import org.nik.moviecatalog.dao.MovieRepository;
import org.nik.moviecatalog.entity.MovieEntity;
import org.nik.moviecatalog.exception.MovieNotFoundException;
import org.nik.moviecatalog.model.Movie;
import org.nik.moviecatalog.model.MovieResponse;
import org.nik.moviecatalog.transform.MovieTransformation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MovieCatalogService {

    @Autowired
    private MovieRepository movieRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(MovieCatalogService.class);

    public ResponseEntity<MovieResponse> getAllMovies(){
        List<Movie> movies = new ArrayList<>();
        Iterable<MovieEntity> movieList = movieRepository.findAll();
        movieList.forEach(movieEntity -> movies.add(MovieTransformation.of(movieEntity)));
        LOGGER.info("Movies retrieved "+ movieList);
        if(movies.isEmpty()) throw new MovieNotFoundException("Movie catalog is empty");
        MovieResponse movieResponse = new MovieResponse();
        movieResponse.setMovies(movies);
        return ResponseEntity.ok(movieResponse);
    }

    public ResponseEntity<Movie> getMovieById(Integer movieId) {
        Optional<MovieEntity> movieEntity = movieRepository.findById(movieId);
        movieEntity.orElseThrow( () -> new MovieNotFoundException("Movie not found for the movieId "+movieId));
        LOGGER.info("Movie details retrieved is "+movieId, movieEntity.get());
        return ResponseEntity.ok(MovieTransformation.of(movieEntity.get()));

    }

    public ResponseEntity<MovieResponse> searchMovie(String movieName){
        List<MovieEntity> movieEntityList = movieRepository.findByMovieNameContaining(movieName);
        LOGGER.info("Movies based on movie name as search criteria are "+movieEntityList);
        if(movieEntityList.isEmpty()) throw new MovieNotFoundException("No movie matched to the search criteria "+movieName);
        List<Movie> movies = new ArrayList<>();
        movieEntityList.forEach(movieEntity -> movies.add(MovieTransformation.of(movieEntity)));
        MovieResponse movieResponse = new MovieResponse();
        movieResponse.setMovies(movies);
        return ResponseEntity.ok(movieResponse);
    }

    public Integer addMovie(Movie movie) {
        MovieEntity movieEntity = MovieTransformation.of(movie);
        MovieEntity movieInserted = movieRepository.save(movieEntity);
        return movieInserted.getMovieId();
    }

    public Integer updateMove(Movie movie) {
        MovieEntity movieEntity = MovieTransformation.of(movie);
        MovieEntity insertedMovie = movieRepository.save(movieEntity);
        return insertedMovie.getMovieId();
    }
}
