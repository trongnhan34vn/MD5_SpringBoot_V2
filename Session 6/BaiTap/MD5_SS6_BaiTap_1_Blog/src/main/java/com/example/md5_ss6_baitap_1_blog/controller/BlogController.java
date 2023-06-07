package com.example.md5_ss6_baitap_1_blog.controller;

import com.example.md5_ss6_baitap_1_blog.model.Blog;
import com.example.md5_ss6_baitap_1_blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @GetMapping
    public String show(Model model) {
        model.addAttribute("listBlog", blogService.findAll());
        return "/index";
    }

    @GetMapping("/create")
    public String formCreate(Model model) {
        model.addAttribute("blog", new Blog());
        return "/create";
    }

    @PostMapping("/create")
    public String createBlog(@ModelAttribute ("blog") Blog blog, Model model) {
        blogService.save(blog);
        model.addAttribute("message", "Write Blog Success! Back to Home to View!");
        return "/create";
    }

    @GetMapping("/delete")
    public String deleteForm(@RequestParam Long id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        return "/delete";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam Long id) {
        blogService.remove(id);
        return "redirect:/";
    }

    @GetMapping("/edit")
    public String showEditForm(@RequestParam Long id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        return "/edit";
    }

    @PostMapping("/update")
    public String updateBlog(@ModelAttribute Blog blog, Model model) {
        blogService.save(blog);
        model.addAttribute("message", "Update Success!");
        return "/edit";
    }
}
