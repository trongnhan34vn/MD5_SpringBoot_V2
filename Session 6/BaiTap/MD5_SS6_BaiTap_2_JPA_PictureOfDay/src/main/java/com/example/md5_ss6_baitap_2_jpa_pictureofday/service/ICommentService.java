package com.example.md5_ss6_baitap_2_jpa_pictureofday.service;

import com.example.md5_ss6_baitap_2_jpa_pictureofday.model.Comment;

import java.util.List;

public interface ICommentService {
    List<Comment> findByDate();
    void save(Comment comment);
    Comment findById(Long id);
}
