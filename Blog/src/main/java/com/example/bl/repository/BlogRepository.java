package com.example.bl.repository;

import com.example.bl.entity.Blogs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blogs,String> {
}
