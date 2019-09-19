package org.nik.movieuser.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.nik.movieuser.model.MovieUser;
import org.nik.movieuser.service.MovieUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "Movie User", tags = "movie-user-controller")
public class MovieUserController {

    @Autowired
    private MovieUserService movieUserService;

    @ApiOperation(value = "getting user details by userId", tags = "get-movie-user")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved the user details"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @GetMapping(value = "/movieuser/{userId}")
    public MovieUser getUser(@PathVariable @ApiParam(name = "UserId", value = "Retrieving User details by userId") String userId){
        return movieUserService.getUser(userId);
    }
}
