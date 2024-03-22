package com.estsoft.blog.oreumi4_blog.service;

import com.estsoft.blog.oreumi4_blog.domain.Comment;
import com.estsoft.blog.oreumi4_blog.dto.AddCommentRequest;
import com.estsoft.blog.oreumi4_blog.repository.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository){
        this.commentRepository = commentRepository;
    }

    //댓글 저장
    public Comment save(AddCommentRequest request){
        return commentRepository.save(request.toEntity());
    }

    public Comment findById(Long articleId, Long commentId){
        //comment 찾는 기능 구현
        //return commentRepository.find
    }

    public List<Comment> findAll(Long articleId){
        //하나의 게시글의 댓글 조회 기능
        //return commentRepository.findAll();
    }
}
