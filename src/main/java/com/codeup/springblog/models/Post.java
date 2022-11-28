package com.codeup.springblog.models;

import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.util.List;


    @Entity
    @Table(name = "posts")
    public class Post {

    @javax.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Column(nullable = false, length = 100)
    private String title;


    @Column(nullable = false, length = 500)
    private String body;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Post() {
    }

    public Post(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public Post(long id, String title, String body) {
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}

