package com.estsoft.blog.oreumi4_blog.dto;

import com.estsoft.blog.oreumi4_blog.domain.Article;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddArticleRequest {
    private String title;
    private String content;

    public Article toEntity() {
        //빌더 사용
        return Article.builder()
                .title(title)
                .content(content)
                .build();
    }
}