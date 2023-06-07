package com.example.md5_ss6_baitap_2_jpa_pictureofday.repository;

import com.example.md5_ss6_baitap_2_jpa_pictureofday.model.Comment;

import java.util.List;

public interface ICommentRepository {
    List<Comment> findByDate();
    void save(Comment comment);
    Comment findById(Long id);
}
