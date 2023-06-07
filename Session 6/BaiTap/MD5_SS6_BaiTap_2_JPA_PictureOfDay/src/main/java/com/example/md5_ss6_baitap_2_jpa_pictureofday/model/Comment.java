package com.example.md5_ss6_baitap_2_jpa_pictureofday.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int point;
    private String author;
    private String message;
    private int amountLike;
    private Date date = new Date();

    public Comment(Long id, int point, String author, String message, int amountLike, Date date) {
        this.id = id;
        this.point = point;
        this.author = author;
        this.message = message;
        this.amountLike = amountLike;
        this.date = new Date();
    }

    public Comment() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getAmountLike() {
        return amountLike;
    }

    public void setAmountLike(int amountLike) {
        this.amountLike = amountLike;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
