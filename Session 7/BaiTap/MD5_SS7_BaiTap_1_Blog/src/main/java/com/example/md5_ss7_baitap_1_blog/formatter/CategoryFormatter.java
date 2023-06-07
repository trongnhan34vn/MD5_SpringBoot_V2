package com.example.md5_ss7_baitap_1_blog.formatter;

import com.example.md5_ss7_baitap_1_blog.model.Category;
import com.example.md5_ss7_baitap_1_blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;
import java.util.Optional;
@Component
public class CategoryFormatter implements Formatter<Category> {
    private ICategoryService categoryService;
    @Autowired
    public CategoryFormatter(ICategoryService categoryService) {
        this.categoryService = categoryService;
    };
    @Override
    public Category parse(String text, Locale locale) throws ParseException {
        Optional<Category> optionalCategory = categoryService.findById(Long.parseLong(text));
        return optionalCategory.orElse(null);
    }

    @Override
    public String print(Category object, Locale locale) {
        return "[" + object.getCategoryId() + ", " +object.getCategoryName() + "]";
    }
}
