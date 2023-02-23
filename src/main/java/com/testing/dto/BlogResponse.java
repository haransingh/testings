package com.testing.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BlogResponse {
    private Long id;
    private String title;
    private String description;
    private LocalDateTime createdAt;
}
