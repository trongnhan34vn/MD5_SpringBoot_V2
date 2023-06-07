package com.example.md5_ss7_baitap_1_blog.repository;

import com.example.md5_ss7_baitap_1_blog.model.Blog;
import com.example.md5_ss7_baitap_1_blog.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBlogRepository extends PagingAndSortingRepository<Blog, Long> {
    Page<Blog> findBlogByCategory(Category category, Pageable pageable);
}
