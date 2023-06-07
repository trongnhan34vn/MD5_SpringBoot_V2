package com.example.md5_ss7_baitap_1_blog.controller;

import com.example.md5_ss7_baitap_1_blog.model.Blog;
import com.example.md5_ss7_baitap_1_blog.service.IBlogService;
import com.example.md5_ss7_baitap_1_blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RequestMapping("/")
@Controller
public class HomeController {
    @Autowired
    private ICategoryService categoryService;
    @Autowired
    private IBlogService blogService;
    @GetMapping
    public String show(Model model) {
        String sortDefault = "title-asc";
        Optional<String> stringOptional = Optional.of(sortDefault);
        return viewPage(1, model, stringOptional);
    }

    @GetMapping("/page/{pageNum}")
    public String viewPage(@PathVariable ("pageNum") int pageNum, Model model,@RequestParam Optional<String> sortBy) {
        Sort sort = null;
        if (sortBy.isPresent()) {
            switch (sortBy.get()) {
                case "title-asc":
                    sort = Sort.by("title").ascending();
                    break;
                case "title-desc":
                    sort = Sort.by("title").descending();
                    break;
            }
        } else {
            sort = Sort.by("title").ascending();
        }
        Pageable pageable = PageRequest.of(pageNum-1, 3, sort);
        Page<Blog> list = blogService.findAll(pageable);
        List<Blog> feedbackList = list.getContent();
        model.addAttribute("currentPage", pageNum);
        model.addAttribute("totalPages", new Arrays[list.getTotalPages()]);
        model.addAttribute("totalElements", list.getTotalElements());
        model.addAttribute("listBlog", feedbackList);
        model.addAttribute("blog", new Blog());
        return "/index";
    }
}
