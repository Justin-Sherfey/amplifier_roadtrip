package com.revature.aspect;

import com.revature.model.exception.InvalidCredentialsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class CatchLoginExceptionAdvice {

    @ExceptionHandler(InvalidCredentialsException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ResponseBody
    public ResponseEntity<?> handleInvalidCredentialsException(final InvalidCredentialsException ice){

        return new ResponseEntity<>(ice.getMessage(),HttpStatus.FORBIDDEN);
    }
}
