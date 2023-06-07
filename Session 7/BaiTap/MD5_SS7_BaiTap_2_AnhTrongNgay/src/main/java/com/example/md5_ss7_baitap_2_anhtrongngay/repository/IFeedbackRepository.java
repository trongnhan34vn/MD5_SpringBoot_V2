package com.example.md5_ss7_baitap_2_anhtrongngay.repository;

import com.example.md5_ss7_baitap_2_anhtrongngay.model.Feedback;
import org.springframework.cglib.core.Local;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface IFeedbackRepository extends PagingAndSortingRepository<Feedback, Long> {
    Iterable<Feedback> findFeedbackByDate(LocalDate date);
    Page<Feedback> findFeedbackByDate(LocalDate date, Pageable pageable);
}
