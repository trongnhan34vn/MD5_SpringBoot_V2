package com.example.md5_ss11_baitap_restful_blog.controller;

import com.example.md5_ss11_baitap_restful_blog.model.Blog;
import com.example.md5_ss11_baitap_restful_blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/blog")
@CrossOrigin("*")
public class BlogController {
    @Autowired

    private IBlogService blogService;
    @GetMapping
    public ResponseEntity<Iterable<Blog>> getAll() {
        List<Blog> blogs = (List<Blog>) blogService.findAll();
        if (blogs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogs,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Blog> saveBlog(@RequestBody Blog blog) {
        return new ResponseEntity<>(blogService.save(blog),HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Blog> findBlogById(@PathVariable ("id") Long id) {
        Optional<Blog> blogOptional = blogService.findById(id);
        if(!blogOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogOptional.get(), HttpStatus.OK);
    }

    @GetMapping("/search/{search}")
    public ResponseEntity<Iterable<Blog>> findBlogsByTitle(@PathVariable ("search") String search) {
        System.out.println("search ------> " + search);
        List<Blog> blogs = (List<Blog>) blogService.searchByTitle(search);
        if (blogs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogs,HttpStatus.OK);
    }
}
