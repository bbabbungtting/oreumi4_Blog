package com.estsoft.blog.oreumi4_blog.domain;

import com.estsoft.blog.oreumi4_blog.dto.CommentResponse;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="comment_id",updatable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "article_id")
    private Article article;

    @Column(name="body", nullable = false)
    private String body;

    @CreatedDate
    @Column(name="created_at")
    private LocalDateTime created_at;

    @Builder
    public Comment(Long articleId, String body){

        this.body = body;
    }

    public CommentResponse toResponse(){
        return CommentResponse.builder()
                .body(body)
                .build();
    }
}
