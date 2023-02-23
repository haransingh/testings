package com.testing.service;

import com.testing.dto.BlogRequest;
import com.testing.entity.Blog;
import com.testing.exceptions.BlogTitleAlreadyExist;
import com.testing.repository.BlogRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class BlogServiceTest {

    @Mock
    private BlogRepository blogRepository;

    private BlogService blogService;

    @Captor
    private ArgumentCaptor<Blog> postArgumentCaptor;

    @Test
    @DisplayName("create blog test case")
    void createBlog() throws BlogTitleAlreadyExist {
        BlogRequest blogRequest = new BlogRequest("new testing blog", "This is a testing description", LocalDateTime.now());
        Blog blog = new Blog(10L, "new testing blog", "This is a testing", LocalDateTime.now());

        Blog blog1 = Blog.builder()
                .title(blogRequest.getTitle())
                .description(blogRequest.getDescription())
                .createdAt(blogRequest.getCreatedAt())
                .build();

        Mockito.when(blog1).thenReturn(blog);

        blogService.createBlog(blogRequest);
        Mockito.verify(blogRepository, Mockito.times(1)).save(postArgumentCaptor.capture());
        Assertions.assertThat(postArgumentCaptor.getValue().getId()).isEqualTo(10L);
    }
}