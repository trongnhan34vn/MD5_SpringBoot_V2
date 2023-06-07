package com.example.md5_ss7_baitap_1_blog.repository;

import com.example.md5_ss7_baitap_1_blog.model.Category;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryRepository extends PagingAndSortingRepository<Category,Long> {
}
