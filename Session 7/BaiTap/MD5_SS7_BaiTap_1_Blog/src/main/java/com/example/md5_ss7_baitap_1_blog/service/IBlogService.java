package com.example.md5_ss7_baitap_1_blog.service;

import com.example.md5_ss7_baitap_1_blog.model.Blog;
import com.example.md5_ss7_baitap_1_blog.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;



public interface IBlogService extends IGenericService<Blog> {
    Page<Blog> findBlogByCategory (Category category, Pageable pageable);
    Page<Blog> findAll (Pageable pageable);
}
