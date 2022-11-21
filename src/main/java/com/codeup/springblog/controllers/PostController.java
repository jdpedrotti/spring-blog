package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Post;
import com.codeup.springblog.repositories.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/posts")
public class PostController {

// Dependency Injection
    private PostRepository postsDao;

    public PostController(PostRepository postsDao) {
        this.postsDao = postsDao;
    }
//^^

    @GetMapping

    public String allPosts(Model model) {
        Post post1 = new Post(1, "First", "This is the first post");
        Post post2 = new Post(2, "Second", "Hey everyone, I'm back lol");
        List<Post> allPosts = new ArrayList<>(List.of(post1, post2));
        model.addAttribute("allPosts", allPosts);

        return "/posts/index";
    }

    @GetMapping("/{id}")

    public String postsID(@PathVariable long id, Model model) {
        Post post3 = new Post(3, "yo", "This is the third post");
        model.addAttribute("post", post3);
//        model.addAttribute("postId", id);
        return "posts/show";
    }


    @GetMapping("/create")
    public String createPost() {
        return "/posts/create";
    }

    @PostMapping("/create")
    public String createPost(@RequestParam(name = "title") String title, @RequestParam(name = "body") String body) {
        Post post = new Post(title, body);
        postsDao.save(post);
        return "redirect:/posts";
    }

}
