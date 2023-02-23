package com.testing.service;

import com.testing.dto.BlogRequest;
import com.testing.dto.BlogResponse;
import com.testing.entity.Blog;
import com.testing.exceptions.BlogTitleAlreadyExist;
import com.testing.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class BlogService {

    @Autowired
    private BlogRepository blogRepository;

    public BlogResponse createBlog(BlogRequest blogRequest) throws BlogTitleAlreadyExist {
        Optional<Blog> getByBlogTitle = blogRepository.findByTitle(blogRequest.getTitle());
        if (getByBlogTitle.isEmpty()) {
            Blog blog = Blog.builder()
                    .title(blogRequest.getTitle())
                    .description(blogRequest.getDescription())
                    .createdAt(LocalDateTime.now())
                    .build();
            blogRepository.save(blog);
            return BlogResponse.builder()
                    .id(blog.getId())
                    .title(blog.getTitle())
                    .description(blog.getDescription())
                    .createdAt(blog.getCreatedAt())
                    .build();
        } else {
            throw new BlogTitleAlreadyExist("Title already exist");
        }
    }

}
