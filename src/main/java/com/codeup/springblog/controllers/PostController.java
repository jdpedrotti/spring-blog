package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    @GetMapping("/posts")
    @ResponseBody
    public String posts() {
        return "posts index page";
    }

    @GetMapping("/posts/{id}")
    @ResponseBody
    public String postsID(@PathVariable long id) {
        return "Post id: " + id;
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String viewPost() {
        return "This is the form to VIEW a post";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String createPost() {
        return "This is the form to CREATE a post";
    }

}
