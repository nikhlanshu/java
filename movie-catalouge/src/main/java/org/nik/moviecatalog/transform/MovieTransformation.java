package org.nik.moviecatalog.transform;

import org.nik.moviecatalog.entity.MovieEntity;
import org.nik.moviecatalog.model.Movie;

import java.util.Objects;

public class MovieTransformation {

    public static Movie of(MovieEntity movieEntity){
        Movie movie = new Movie();
        movie.setDesc(movieEntity.getDesc());
        movie.setGenre(movieEntity.getGenre());
        movie.setMovieId(movieEntity.getMovieId());
        movie.setMovieName(movieEntity.getMovieName());
        movie.setReleaseDate(movieEntity.getRelDate());
        return movie;
    }

    public static MovieEntity of(Movie movie){
        MovieEntity movieEntity = new MovieEntity();
        if(Objects.nonNull(movie.getDesc())) movieEntity.setDesc(movie.getDesc());
        if(Objects.nonNull(movie.getGenre())) movieEntity.setGenre(movie.getGenre());
        if(Objects.nonNull(movie.getMovieId())) movieEntity.setMovieId(Integer.valueOf(movie.getMovieId()));
        if(Objects.nonNull(movie.getMovieName())) movieEntity.setMovieName(movie.getMovieName());
        if(Objects.nonNull(movie.getReleaseDate())) movieEntity.setRelDate(movie.getReleaseDate());
        return movieEntity;
    }
}
