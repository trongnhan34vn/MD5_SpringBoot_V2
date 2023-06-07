package com.example.md5_ss5_baitap2_showimage.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table (name = "Feedback")
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String author;
    private int point;
    @Column(columnDefinition = "TEXT")
    private String message;
    private Date date = new Date();
    private int countLike;

    public Feedback(int id, String author, int point, String message, Date date, int countLike) {
        this.id = id;
        this.author = author;
        this.point = point;
        this.message = message;
        this.date = new Date();
        this.countLike = countLike;
    }

    public Feedback() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getCountLike() {
        return countLike;
    }

    public void setCountLike(int countLike) {
        this.countLike = countLike;
    }
}
