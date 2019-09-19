package org.nik.moviecatalog.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.nik.moviecatalog.model.Movie;
import org.nik.moviecatalog.model.MovieResponse;
import org.nik.moviecatalog.service.MovieCatalogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(value = "Movie catalog controller", tags = "movie-catalog")
public class MovieCatalogController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MovieCatalogController.class);

    @Autowired
    private MovieCatalogService movieCatalogService;

    @GetMapping(value = "/movies")
    @ApiOperation(value = "Get All movies", notes = "Gets all movies irrespective of any condition", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved movie list"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    public ResponseEntity<MovieResponse> getMovies(){
        LOGGER.info("GetMovies called, list all the movies>");
        return movieCatalogService.getAllMovies();
    }

    @GetMapping(value = "/movies/{movieId}")
    @ApiOperation(value = "Get a movie by movie Id", notes = "Gets a movie if the movie id is supplied")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved movie"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    public ResponseEntity<Movie> getMovie(@ApiParam(value = "Movie id which which uniquely identifies each movie. It can t be same for tow movies") @PathVariable Integer movieId){
        LOGGER.info("Get movie details by movieId "+movieId);
        return movieCatalogService.getMovieById(movieId);
    }
    @GetMapping(value = "/movies/search")
    @ApiOperation(value = "Search a movie based on movie name", notes = "Retrieves all the movies that matches with the search pattern. The given search pattern need not to match entirely")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved movie list"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    public ResponseEntity<MovieResponse> searchMovie(@ApiParam(value = "Movie name to be searched") @RequestParam String movieName){
        LOGGER.info("Search Movies based on Movie by "+movieName);
        return movieCatalogService.searchMovie(movieName);
    }

    @PostMapping(value = "/movies")
    @ApiOperation(value = "Add a movie to the movie catalog", notes = "Add a movie to the movie catalog")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successfully created a movie"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    public Integer addMovie(@ApiParam(value = "Passing movie details in the request body") @RequestBody Movie movie){
        LOGGER.info("Adding movie "+movie);
        return movieCatalogService.addMovie(movie);
    }

    @PatchMapping(value = "/movies/{movieId}")
    @ApiOperation(value = "Update movie details", notes = "updates a movie in the catalog")
    @ApiResponses(value = {
            @ApiResponse(code = 202, message = "Successfully updated a movie"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    public Integer updateMovie(@ApiParam(value = "Passing movie details in the request body for update") @RequestBody Movie movie){
        return movieCatalogService.updateMove(movie);
    }
}
