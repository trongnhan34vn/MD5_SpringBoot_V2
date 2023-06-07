package com.example.md5_ss7_baitap_2_anhtrongngay.controller;

import com.example.md5_ss7_baitap_2_anhtrongngay.model.Feedback;
import com.example.md5_ss7_baitap_2_anhtrongngay.service.IFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/")
public class FeedbackController {

    @Autowired
    private IFeedbackService feedbackService;
    @GetMapping
    public String show(Model model) {
        return viewPage(model, 1);
    }

    @GetMapping("/page/{pageNum}")
    public String viewPage(Model model, @PathVariable("pageNum") int pageNum) {
        Pageable pageable = PageRequest.of(pageNum - 1, 3);
        Page<Feedback> feedbackPage = feedbackService.findFeedbackByDate(pageable);
        List<Feedback> feedbackList = feedbackPage.getContent();
        model.addAttribute("currentPage", pageNum);
        model.addAttribute("totalPages", new Arrays[feedbackPage.getTotalPages()]);
        model.addAttribute("totalElements", feedbackPage.getTotalElements());
        model.addAttribute("feedbackList", feedbackList);
        model.addAttribute("feedback", new Feedback());
        return "/index";
    }

    @PostMapping("/create")
    public String createFeed(@ModelAttribute ("feedback") Feedback feedback) {
        feedbackService.save(feedback);
        return "redirect:/";
    }

    @GetMapping("/like")
    public String likeFeed(@RequestParam("id") Long id) {
        Feedback selectFeed = feedbackService.findById(id).get();
        selectFeed.setLikeAmount(selectFeed.getLikeAmount() + 1);
        feedbackService.save(selectFeed);
        return "redirect:/";
    }
}
