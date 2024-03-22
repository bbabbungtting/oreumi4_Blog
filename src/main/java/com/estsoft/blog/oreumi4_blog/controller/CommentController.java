package com.estsoft.blog.oreumi4_blog.controller;

import com.estsoft.blog.oreumi4_blog.domain.Comment;
import com.estsoft.blog.oreumi4_blog.dto.AddCommentRequest;
import com.estsoft.blog.oreumi4_blog.dto.CommentResponse;
import com.estsoft.blog.oreumi4_blog.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class CommentController {
    private CommentService commentService;

    public CommentController(CommentService commentService){
        this.commentService = commentService;
    }

    @PostMapping("/api/comments/{articleId}")
    public ResponseEntity<CommentResponse> addComment(@PathVariable Long articleId, @RequestBody AddCommentRequest request){
        Comment comment = commentService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(comment.toResponse());

    }

    @GetMapping("/api/comments/{articleId}/{commentId}")
    public ResponseEntity<CommentResponse> findCommentById(@PathVariable Long articleId, Long commentId){
        Comment comment = commentService.findById(articleId,commentId);

        return ResponseEntity.status(HttpStatus.OK)
                .body(comment.toResponse());
    }

    @GetMapping("/api/comments/{articleId}")
    public ResponseEntity<List<CommentResponse>> findAllComments(@PathVariable Long articleId){
        List<CommentResponse> list = commentService.findAll(articleId)
                .stream().map(CommentResponse::new)
                .toList();

        return ResponseEntity.status(HttpStatus.OK)
                .body(list);
    }


}
