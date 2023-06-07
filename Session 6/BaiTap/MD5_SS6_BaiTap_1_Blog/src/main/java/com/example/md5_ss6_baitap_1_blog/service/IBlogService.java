package com.example.md5_ss6_baitap_1_blog.service;

import com.example.md5_ss6_baitap_1_blog.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();
    Blog findById(Long id);
    void save(Blog blog);
    void remove(Long id);
}
