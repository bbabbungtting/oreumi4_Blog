package com.estsoft.blog.oreumi4_blog.dto;

import com.estsoft.blog.oreumi4_blog.domain.Comment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class CommentResponse {
    private Long article_id;
    private String body;

    public CommentResponse(Comment comment){
        this.body = comment.getBody();
    }
}
