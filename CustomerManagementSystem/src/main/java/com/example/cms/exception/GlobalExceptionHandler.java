package com.example.cms.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

	//User-defined exception handlers:

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<CustomExceptions> customerExceptionHandler(CustomerNotFoundException isf, WebRequest req) {

        CustomExceptions customizeErr = new CustomExceptions(LocalDateTime.now(), isf.getMessage(), req.getDescription(false));

        return new ResponseEntity<CustomExceptions>(customizeErr, HttpStatus.BAD_REQUEST);
    }
    
    
    @ExceptionHandler(LoginException.class)
    public ResponseEntity<CustomExceptions> loginExceptionHandler(LoginException isf, WebRequest req) {

        CustomExceptions customizeErr = new CustomExceptions(LocalDateTime.now(), isf.getMessage(), req.getDescription(false));

        return new ResponseEntity<CustomExceptions>(customizeErr, HttpStatus.BAD_REQUEST);
    }
    

    //possible exception handlers:

    @ExceptionHandler(NoSuchMethodException.class)
    public ResponseEntity<CustomExceptions> noSuchMethodExceptionHandler(NoSuchMethodException nsme, WebRequest req) {

        CustomExceptions err = new CustomExceptions();
        err.setTimeStamp(LocalDateTime.now());
        err.setMessage(nsme.getMessage());
        err.setErrorDetails(req.getDescription(false));


        return new ResponseEntity<CustomExceptions>(err, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<CustomExceptions> noHandlerFoundExpHandler(NoHandlerFoundException nhfe, WebRequest req) {

        CustomExceptions err = new CustomExceptions(LocalDateTime.now(), nhfe.getMessage(), req.getDescription(false));

        return new ResponseEntity<CustomExceptions>(err, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<CustomExceptions> myMANVExceptionHandler(MethodArgumentNotValidException manve) {

        CustomExceptions err = new CustomExceptions();
        err.setTimeStamp(LocalDateTime.now());
        err.setMessage("Validation Error!");
        err.setErrorDetails(manve.getBindingResult().getFieldError().getDefaultMessage());


        return new ResponseEntity<CustomExceptions>(err, HttpStatus.BAD_REQUEST);
    }


    //Generic exception handler:

    @ExceptionHandler(Exception.class)
    public ResponseEntity<CustomExceptions> otherExceptionHandler(Exception e, WebRequest req) {

        CustomExceptions error = new CustomExceptions();
        error.setTimeStamp(LocalDateTime.now());
        error.setMessage(e.getMessage());
        error.setErrorDetails(req.getDescription(false));

        return new ResponseEntity<CustomExceptions>(error, HttpStatus.NOT_FOUND);
    }

}
