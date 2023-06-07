package com.example.md5_ss7_baitap_2_anhtrongngay.service;

import com.example.md5_ss7_baitap_2_anhtrongngay.model.Feedback;
import com.example.md5_ss7_baitap_2_anhtrongngay.repository.IFeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.Optional;
@Service
public class FeedbackServiceIMPL implements IFeedbackService{
    @Autowired
    private IFeedbackRepository feedbackRepository;
    @Override
    public Iterable<Feedback> findFeedbackByDate() {
        LocalDate currentDate = LocalDate.now();
        return feedbackRepository.findFeedbackByDate(currentDate);
    }

    @Override
    public void save(Feedback feedback) {
        feedbackRepository.save(feedback);
    }

    @Override
    public void remove(Long id) {
        feedbackRepository.deleteById(id);
    }

    @Override
    public Optional<Feedback> findById(Long id) {
        return feedbackRepository.findById(id);
    }

    @Override
    public Page<Feedback> findFeedbackByDate(Pageable pageable) {
        LocalDate currentDate = LocalDate.now();
        return feedbackRepository.findFeedbackByDate(currentDate, pageable);
    }

}
