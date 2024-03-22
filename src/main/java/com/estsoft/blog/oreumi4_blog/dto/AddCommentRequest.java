package com.estsoft.blog.oreumi4_blog.dto;

import com.estsoft.blog.oreumi4_blog.domain.Comment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddCommentRequest {
    private Long article_id;
    private String body;

    public Comment toEntity(){
        return Comment.builder()
                .body(body)
                .build();
    }
}
