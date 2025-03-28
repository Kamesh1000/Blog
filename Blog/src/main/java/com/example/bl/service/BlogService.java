package com.example.bl.service;

import com.example.bl.entity.Blogs;

import java.util.List;

public interface BlogService {
    Blogs addBlog(Blogs blogs);
    List<Blogs> getAllBlogs();
    Blogs getBlogById(String blogId);
    void updateBlog(Blogs blogs);
    void deleteBlog(String blogId);
}
