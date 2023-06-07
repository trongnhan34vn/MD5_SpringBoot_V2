package com.example.md5_ss7_baitap_2_anhtrongngay.model;

import org.springframework.cglib.core.Local;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "TEXT")
    private String content;
    private String author;
    private int point;
    private int likeAmount;
    @Column(columnDefinition = "DATE")
    private LocalDate date = LocalDate.now();

    public Feedback() {
    }

    public Feedback(Long id, String content, String author, int point, int likeAmount, LocalDate date) {
        this.id = id;
        this.content = content;
        this.author = author;
        this.point = point;
        this.likeAmount = likeAmount;
        this.date = LocalDate.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public int getLikeAmount() {
        return likeAmount;
    }

    public void setLikeAmount(int likeAmount) {
        this.likeAmount = likeAmount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
