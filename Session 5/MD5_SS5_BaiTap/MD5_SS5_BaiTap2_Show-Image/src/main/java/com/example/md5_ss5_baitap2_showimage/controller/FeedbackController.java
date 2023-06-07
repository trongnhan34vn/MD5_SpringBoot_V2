package com.example.md5_ss5_baitap2_showimage.controller;

import com.example.md5_ss5_baitap2_showimage.model.Feedback;
import com.example.md5_ss5_baitap2_showimage.service.FeedbackServiceIMPL;
import com.example.md5_ss5_baitap2_showimage.service.IFeedbackService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class FeedbackController {
    IFeedbackService feedbackService = new FeedbackServiceIMPL();

    @GetMapping
    public String showComment(Model model) {
        model.addAttribute("feedback", new Feedback());
        model.addAttribute("listFeed", feedbackService.findAll());
        System.out.println(feedbackService.findAll());
        return "/index";
    }

    @PostMapping("/comment")
    public String comment(@ModelAttribute Feedback feedback) {
        feedbackService.save(feedback);
        return "redirect:/";
    }

    @GetMapping("/like")
    public String like(@RequestParam ("id") int id)  {
        Feedback selectFeed = feedbackService.findById(id);
        selectFeed.setCountLike(selectFeed.getCountLike()+1);
        feedbackService.save(selectFeed);
        return "redirect:/";
    }
}
