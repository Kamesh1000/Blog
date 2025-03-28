package com.example.bl.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name ="Blogs Table")
public class Blogs {

    @Id
    private String blogId;
    private String title;
    private String content;
    private String author;
    private String createdDate;
}
