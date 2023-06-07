package com.example.md5_ss7_baitap_1_blog.model;

import javax.persistence.*;

@Entity
@Table (name = "blog")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long blogId;
    private String title;
    @Column(columnDefinition = "TEXT")
    private String content;
    @ManyToOne
    @JoinColumn(name = "categoryId")
    private Category category;

    public Blog() {
    }

    public Blog(Long blogId, String title, String content, Category category) {
        this.blogId = blogId;
        this.title = title;
        this.content = content;
        this.category = category;
    }

    public Long getBlogId() {
        return blogId;
    }

    public void setBlogId(Long blogId) {
        this.blogId = blogId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return String.format("Blog[id=%d, title='%s']", blogId, title);
    }
}
