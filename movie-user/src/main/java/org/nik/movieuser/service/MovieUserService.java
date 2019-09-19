package org.nik.movieuser.service;

import org.nik.movieuser.dao.MovieUserRepository;
import org.nik.movieuser.entity.MovieUserEntity;
import org.nik.movieuser.exception.UserNotFoundException;
import org.nik.movieuser.model.MovieUser;
import org.nik.movieuser.translator.MovieUserTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MovieUserService {

    @Autowired
    private MovieUserRepository movieUserRepository;

    public MovieUser getUser(String userId){
        Optional<MovieUserEntity> movieUserEntity = movieUserRepository.findById(userId);
        return movieUserEntity.map(MovieUserTranslator::of).orElseThrow(() -> new UserNotFoundException("No user found for userId "+userId));
    }
}
