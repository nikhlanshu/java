package org.nik.moviecatalog.handler;

import org.nik.moviecatalog.exception.MovieNotFoundException;
import org.nik.moviecatalog.model.ErrorDetails;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class MovieCatalogExceptionHandler {

    @ExceptionHandler(MovieNotFoundException.class)
    public ResponseEntity<ErrorDetails> movieNotFoundException(MovieNotFoundException movieNotFoundException, WebRequest webRequest){
        ErrorDetails errorDetails = new ErrorDetails(movieNotFoundException.getCause(), new Date(), "1001", movieNotFoundException.getMessage());
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DataAccessException.class)
    public ResponseEntity<ErrorDetails> dataAccessException(DataAccessException dataAccessException, WebRequest webRequest){
        ErrorDetails errorDetails = new ErrorDetails(dataAccessException.getCause(), new Date(), "1002", dataAccessException.getMessage());
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
