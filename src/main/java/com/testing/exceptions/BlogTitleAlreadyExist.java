package com.testing.exceptions;

public class BlogTitleAlreadyExist extends Exception {
    public BlogTitleAlreadyExist(String message) {
        super(message);
    }
}
