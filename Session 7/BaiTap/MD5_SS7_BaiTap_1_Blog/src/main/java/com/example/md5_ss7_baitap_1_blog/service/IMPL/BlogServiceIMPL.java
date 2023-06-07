package com.example.md5_ss7_baitap_1_blog.service.IMPL;

import com.example.md5_ss7_baitap_1_blog.model.Blog;
import com.example.md5_ss7_baitap_1_blog.model.Category;
import com.example.md5_ss7_baitap_1_blog.repository.IBlogRepository;
import com.example.md5_ss7_baitap_1_blog.repository.ICategoryRepository;
import com.example.md5_ss7_baitap_1_blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class BlogServiceIMPL implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public Page<Blog> findBlogByCategory(Category category, Pageable pageable) {
        return blogRepository.findBlogByCategory(category, pageable);
    }

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @Override
    public Iterable<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Optional<Blog> findById(Long id) {
        return blogRepository.findById(id);
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void remove(Long id) {
        blogRepository.deleteById(id);
    }
}
