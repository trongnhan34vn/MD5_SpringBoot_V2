package com.example.md5_ss6_baitap_2_jpa_pictureofday.service;

import com.example.md5_ss6_baitap_2_jpa_pictureofday.model.Comment;
import com.example.md5_ss6_baitap_2_jpa_pictureofday.repository.ICommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CommentService implements ICommentService{
    @Autowired
    private ICommentRepository commentRepository;
    @Override
    public List<Comment> findByDate() {
        return commentRepository.findByDate();
    }

    @Override
    public void save(Comment comment) {
        commentRepository.save(comment);
    }

    @Override
    public Comment findById(Long id) {
       return commentRepository.findById(id);
    }
}
