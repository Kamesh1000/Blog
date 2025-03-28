package com.example.bl.service;

import com.example.bl.entity.Blogs;
import com.example.bl.exception.BlogNotFoundByIdException;
import com.example.bl.repository.BlogRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BlogServiceImplementation implements BlogService{
    private final BlogRepository blogRepository;

    BlogServiceImplementation(BlogRepository blogRepository){
        this.blogRepository=blogRepository;
    }

    @Override
    public Blogs addBlog(Blogs blogs) {
        blogs.setBlogId(UUID.randomUUID().toString());
        return blogRepository.save(blogs);
    }

    @Override
    public List<Blogs> getAllBlogs() {
        return blogRepository.findAll();
    }

    @Override
    public Blogs getBlogById(String blogId) {
        return blogRepository.findById(blogId).orElseThrow(()->new BlogNotFoundByIdException("Blog not found by id"));
    }

    @Override
    public void updateBlog(Blogs blogs) {
        blogRepository.save(blogs);
    }

    @Override
    public void deleteBlog(String blogId) {
        blogRepository.findById(blogId).ifPresentOrElse(x->blogRepository.delete(x),()->new BlogNotFoundByIdException("Blog Not Found"));
    }
}
