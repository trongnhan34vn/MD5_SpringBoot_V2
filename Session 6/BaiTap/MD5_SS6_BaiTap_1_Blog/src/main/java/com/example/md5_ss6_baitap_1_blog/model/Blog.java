package com.example.md5_ss6_baitap_1_blog.model;

import javax.persistence.*;

@Entity
@Table (name = "Blog")
public class Blog {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    private String title;

    public Blog(Long id, String content, String title) {
        this.id = id;
        this.content = content;
        this.title = title;
    }

    public Blog() {
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
