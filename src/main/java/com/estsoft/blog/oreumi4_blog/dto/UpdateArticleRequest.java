package com.estsoft.blog.oreumi4_blog.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UpdateArticleRequest {
    private String title;
    private String content;
}