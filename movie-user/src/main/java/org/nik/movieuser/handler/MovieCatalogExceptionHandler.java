package org.nik.movieuser.handler;

import org.nik.movieuser.exception.UserNotFoundException;
import org.nik.movieuser.model.ErrorDetails;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class MovieCatalogExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorDetails> userNotFoundException(UserNotFoundException movieNotFoundException, WebRequest webRequest){
        ErrorDetails errorDetails = new ErrorDetails(movieNotFoundException.getCause(), new Date(), "1001", movieNotFoundException.getMessage());
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DataAccessException.class)
    public ResponseEntity<ErrorDetails> dataAccessException(DataAccessException dataAccessException, WebRequest webRequest){
        ErrorDetails errorDetails = new ErrorDetails(dataAccessException.getCause(), new Date(), "1002", dataAccessException.getMessage());
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
