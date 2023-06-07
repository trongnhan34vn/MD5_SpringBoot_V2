package com.example.md5_ss7_baitap_1_blog.controller;

import com.example.md5_ss7_baitap_1_blog.model.Blog;
import com.example.md5_ss7_baitap_1_blog.model.Category;
import com.example.md5_ss7_baitap_1_blog.service.IBlogService;
import com.example.md5_ss7_baitap_1_blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @Autowired
    private ICategoryService categoryService;

    @GetMapping
    public String show(Model model) {
        model.addAttribute("listBlog", blogService.findAll());
        return "/blog/show";
    }

    @ModelAttribute("listCategory")
    public Iterable<Category> categories() {
        return categoryService.findAll();
    }

    @GetMapping("/create")
    public String createForm (Model model) {
        model.addAttribute("blog", new Blog());
        return "/blog/create";
    }

    @PostMapping("/create")
    public String createBlog(@ModelAttribute ("blog") Blog blog, Model model) {
        blogService.save(blog);
        model.addAttribute("message", "Create Success!");
        model.addAttribute("blog", new Blog());
        return "/blog/create";
    }

    @GetMapping("/edit")
    public String editForm(Model model, @RequestParam ("id") Long id) {
        model.addAttribute("blog", blogService.findById(id));
        return "/blog/edit";
    }

    @PostMapping("/update")
    public String updateBlog(@ModelAttribute ("blog") Blog blog, Model model) {
        blogService.save(blog);
        model.addAttribute("message", "Update Success!");
        return "/blog/edit";
    }

    @GetMapping("/delete")
    public String deleteForm(@RequestParam("id") Long id, Model model) {
        model.addAttribute("blog", blogService.findById(id).get());
        return "/blog/delete";
    }

    @PostMapping("/delete")
    public String deleteBlog(@ModelAttribute("blog") Blog blog) {
        blogService.remove(blog.getBlogId());
        return "redirect:/";
    }
}
