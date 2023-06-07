package com.example.md5_ss7_baitap_1_blog.controller;

import com.example.md5_ss7_baitap_1_blog.model.Category;
import com.example.md5_ss7_baitap_1_blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    @GetMapping
    public String show(Model model) {
        model.addAttribute("listBlog", categoryService.findAll());
        return "/category/show";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("category", new Category());
        return "/category/create";
    }

    @PostMapping("/create")
    public String createCategory(@ModelAttribute Category category, Model model) {
        categoryService.save(category);
        model.addAttribute("message", "Create Category Success!");
        return "/category/create";
    }
}
