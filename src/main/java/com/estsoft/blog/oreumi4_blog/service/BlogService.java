package com.estsoft.blog.oreumi4_blog.service;

import com.estsoft.blog.oreumi4_blog.domain.Article;
import com.estsoft.blog.oreumi4_blog.dto.AddArticleRequest;
import com.estsoft.blog.oreumi4_blog.dto.UpdateArticleRequest;
import com.estsoft.blog.oreumi4_blog.repository.BlogRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//해당 클래스를 빈으로 서블릿 컨테이너에 등록해준다.
@Service
public class BlogService {

    private final BlogRepository blogRepository;

    public BlogService(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    //글 저장
    public Article save(AddArticleRequest request) {
        return blogRepository.save(request.toEntity());
    }

    //글 전체 조회
    public List<Article> findAll() {
        return blogRepository.findAll();
    }

    //id로 글 하나 조회
    public Article findOne(Long id){
        return blogRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("not found id" + id));
        //return blogRepository.findById(id).orElse(new Article());
    }

    //글 삭제
    //DELETE FROM article WHERE id = ${id}
    public void delete(Long id) {
        blogRepository.deleteById(id);
    }

    //글 수정
    @Transactional
    public Article update(Long id, UpdateArticleRequest request) {
        Article article = blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found " + id));

        article.update(request.getTitle(), request.getContent());
        return article;
    }

}
