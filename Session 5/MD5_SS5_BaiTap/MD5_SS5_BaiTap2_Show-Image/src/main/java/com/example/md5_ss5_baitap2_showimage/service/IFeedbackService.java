package com.example.md5_ss5_baitap2_showimage.service;

import com.example.md5_ss5_baitap2_showimage.model.Feedback;

import java.util.List;

public interface IFeedbackService {
    List<Feedback> findAll();
    void save(Feedback feedback);
    Feedback findById(int id);
}
