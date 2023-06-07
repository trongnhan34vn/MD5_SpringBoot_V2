package com.example.md5_ss11_baitap_restful_blog.service;

import com.example.md5_ss11_baitap_restful_blog.model.Blog;
import com.example.md5_ss11_baitap_restful_blog.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class BlogServiceIMPL implements IBlogService{
    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public Iterable<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Optional<Blog> findById(Long id) {
        return blogRepository.findById(id);
    }

    @Override
    public Blog save(Blog blog) {
        return blogRepository.save(blog);
    }

    @Override
    public void remove(Long id) {
        blogRepository.deleteById(id);
    }

    @Override
    public Iterable<Blog> searchByTitle(String search) {
        return blogRepository.findBlogsByTitle(search);
    }
}
