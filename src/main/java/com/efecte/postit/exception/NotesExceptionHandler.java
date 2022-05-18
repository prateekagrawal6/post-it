package com.efecte.postit.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * NotesExceptionHandler to handle all the exception in one roof
 */
@ControllerAdvice
@Slf4j
public class NotesExceptionHandler {

    /**
     * handleEmptyResult method to handle the EmptyResultDataAccessException
     * @param request   HttpServletRequest
     * @param exception EmptyResultDataAccessException
     * @return  returns a response entity with an HttpStatus
     */
    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseEntity<HttpStatus> handleEmptyResult(HttpServletRequest request, EmptyResultDataAccessException exception) {
        log.error("Request: {} raised {}", request.getRequestURL(), exception);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * handleError method to handle the Exception
     * @param request   HttpServletRequest
     * @param exception Exception
     * @return  returns a response entity with a message
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleError(HttpServletRequest request, Exception exception) {
        log.error("Request: {} raised {}", request.getRequestURL(), exception);
        return new ResponseEntity<>("Something went wrong, please try again later.", HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
