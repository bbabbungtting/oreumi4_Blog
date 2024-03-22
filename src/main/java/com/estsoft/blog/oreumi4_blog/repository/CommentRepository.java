package com.estsoft.blog.oreumi4_blog.repository;

import com.estsoft.blog.oreumi4_blog.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Long> {
}
