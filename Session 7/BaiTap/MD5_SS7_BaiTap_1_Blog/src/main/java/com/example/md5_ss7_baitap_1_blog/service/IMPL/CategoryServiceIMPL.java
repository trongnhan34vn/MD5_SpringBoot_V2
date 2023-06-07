package com.example.md5_ss7_baitap_1_blog.service.IMPL;

import com.example.md5_ss7_baitap_1_blog.model.Category;
import com.example.md5_ss7_baitap_1_blog.repository.ICategoryRepository;
import com.example.md5_ss7_baitap_1_blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class CategoryServiceIMPL implements ICategoryService {
    @Autowired
    private ICategoryRepository categoryRepository;
    @Override
    public Iterable<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Category> findById(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public void save(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public void remove(Long id) {
        categoryRepository.deleteById(id);
    }
}
