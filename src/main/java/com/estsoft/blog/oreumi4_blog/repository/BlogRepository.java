package com.estsoft.blog.oreumi4_blog.repository;

import com.estsoft.blog.oreumi4_blog.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Article, Long> {

}
