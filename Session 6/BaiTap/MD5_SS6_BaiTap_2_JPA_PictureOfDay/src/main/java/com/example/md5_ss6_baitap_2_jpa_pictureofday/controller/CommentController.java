package com.example.md5_ss6_baitap_2_jpa_pictureofday.controller;

import com.example.md5_ss6_baitap_2_jpa_pictureofday.model.Comment;
import com.example.md5_ss6_baitap_2_jpa_pictureofday.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class CommentController {
    @Autowired
    private ICommentService commentService;
    @GetMapping
    public String show(Model model) {
        model.addAttribute("listFeed", commentService.findByDate());
        model.addAttribute("comment", new Comment());
        return "/index";
    }

    @PostMapping("/comment")
    public String comment(@ModelAttribute Comment comment) {
        commentService.save(comment);
        return "redirect:/";
    }
}
