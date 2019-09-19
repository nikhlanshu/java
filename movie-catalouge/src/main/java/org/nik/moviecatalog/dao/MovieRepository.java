package org.nik.moviecatalog.dao;

import org.nik.moviecatalog.entity.MovieEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends CrudRepository<MovieEntity, Integer> {
    List<MovieEntity> findByMovieNameContaining(String movieName);

}
