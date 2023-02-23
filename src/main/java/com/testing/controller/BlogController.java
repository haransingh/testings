package com.testing.controller;

import com.testing.dto.BlogRequest;
import com.testing.dto.BlogResponse;
import com.testing.exceptions.BlogTitleAlreadyExist;
import com.testing.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @PostMapping("/create")
    public BlogResponse createBlog(@RequestBody BlogRequest blogRequest) throws BlogTitleAlreadyExist {
        return blogService.createBlog(blogRequest);
    }
}
