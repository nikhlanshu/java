package org.nik.movieuser.dao;

import org.nik.movieuser.entity.MovieUserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieUserRepository extends CrudRepository<MovieUserEntity, String> {

}
