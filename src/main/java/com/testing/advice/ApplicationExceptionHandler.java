package com.testing.advice;

import com.testing.exceptions.BlogTitleAlreadyExist;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ApplicationExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BlogTitleAlreadyExist.class)
    public Map<String, String> titleAlreadyExist(BlogTitleAlreadyExist ex) {
        Map<String, String> errorMessage = new HashMap<>();
        errorMessage.put("errorMessage", ex.getMessage());
        return errorMessage;
    }

}
