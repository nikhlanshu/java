package org.nik.movieuser.translator;

import org.nik.movieuser.entity.MovieUserEntity;
import org.nik.movieuser.model.MovieUser;

public class MovieUserTranslator {

    public static MovieUser of(MovieUserEntity movieUserEntity){
        MovieUser movieUser = new MovieUser();
        movieUser.setDateOfBirth(movieUserEntity.getDob());
        movieUser.setGender(movieUserEntity.getGender());
        movieUser.setUserId(movieUserEntity.getUserId());
        return movieUser;
    }
    public static MovieUser empty(){
        return new MovieUser();
    }
}
