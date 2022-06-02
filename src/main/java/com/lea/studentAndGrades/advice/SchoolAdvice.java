package com.lea.studentAndGrades.advice;

import com.lea.studentAndGrades.exceptions.SchoolSystemException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
public class SchoolAdvice {
    @ExceptionHandler(value = {SchoolSystemException.class})
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ErrorDetail schoolHandler(Exception err){
        return new ErrorDetail("school problem", err.getMessage());
    }
}
