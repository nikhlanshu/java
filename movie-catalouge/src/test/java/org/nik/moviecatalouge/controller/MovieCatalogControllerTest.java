package org.nik.moviecatalouge.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.nik.moviecatalog.MovieCatalogApplication;
import org.nik.moviecatalog.dao.MovieRepository;
import org.nik.moviecatalog.entity.MovieEntity;
import org.nik.moviecatalog.model.Movie;
import org.nik.moviecatalog.model.MovieResponse;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = MovieCatalogApplication.class)
@RunWith(SpringRunner.class)
public class MovieCatalogControllerTest {

    @LocalServerPort
    private int port;
    private TestRestTemplate restTemplate = new TestRestTemplate();
    private HttpHeaders headers = new HttpHeaders();

    @Test
    public void getMoviesTest(){
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<MovieResponse> getAllMoviesResponse = restTemplate.exchange(createURLWithPort("/movies"), HttpMethod.GET, entity, MovieResponse.class);
        List<Movie> movies = getAllMoviesResponse.getBody().getMovies();
        assertEquals(movies.size(), 2);
    }


    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }

}
