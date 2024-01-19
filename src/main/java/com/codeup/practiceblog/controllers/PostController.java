package com.codeup.practiceblog.controllers;

import com.codeup.practiceblog.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

    Post post1 = new Post("Hello", "How are you doing today? Great weather, right?");
    Post post2 = new Post("Goodbye", "Screw you guys, I'm going home.");

    List<Post> posts = new ArrayList<>(List.of(post1, post2));

    @GetMapping("/posts")
    public String index(Model model) {

        model.addAttribute("posts", posts);
        return "/posts/index";
    }

    @GetMapping("posts/{id}")
    public String getPost(@PathVariable int id, Model model) {

        Post newPost = new Post(id, "My Post", "This is where I tell you how much I hate everything.");
        model.addAttribute("post", newPost);
        return "/posts/show";
    }

    @GetMapping("posts/create")
    @ResponseBody
    public String createPost() {
        return "view the form for creating a post";
    }

    @PostMapping("posts/create")
    @ResponseBody
    public String newPost() {
        return "create a new post";
    }
}
