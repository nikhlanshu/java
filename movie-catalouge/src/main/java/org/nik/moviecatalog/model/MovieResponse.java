package org.nik.moviecatalog.model;

import java.util.List;

public class MovieResponse {
    private List<Movie> movies;

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }
}
