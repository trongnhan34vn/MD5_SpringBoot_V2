package com.example.md5_ss11_baitap_restful_blog.repository;

import com.example.md5_ss11_baitap_restful_blog.model.Blog;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IBlogRepository extends PagingAndSortingRepository<Blog,Long> {
    @Query(value = "SELECT * FROM Blogs where title like %:name%", nativeQuery = true)
    Iterable<Blog> findBlogsByTitle(@Param("name") String name);
}
