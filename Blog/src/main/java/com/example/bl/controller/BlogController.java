package com.example.bl.controller;

import com.example.bl.entity.Blogs;
import com.example.bl.service.BlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blog")
public class BlogController {

    private final BlogService service ;

    BlogController(BlogService service){
        this.service=service;
    }

    @PostMapping("/add-blog")
    public ResponseEntity<Blogs> addBlog(@RequestBody Blogs blogs){
        return ResponseEntity.status(HttpStatus.OK).body(service.addBlog(blogs));
    }

    @GetMapping
    public ResponseEntity<List<Blogs>> getAllBlogs(){
        return ResponseEntity.status(HttpStatus.OK).body(service.getAllBlogs());
    }

    @GetMapping("/get-blog")
    public ResponseEntity<Blogs> getBlogById(@RequestParam String blogId){
        return ResponseEntity.status(HttpStatus.OK).body(service.getBlogById(blogId));
    }

    @PutMapping("/update-blog")
    public ResponseEntity updateBlog(@RequestBody Blogs blogs){
        service.updateBlog(blogs);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
    @GetMapping("/delete-blog{blogId}")
    public ResponseEntity deleteBlog(@PathVariable String blogId){
        service.deleteBlog(blogId);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
}
