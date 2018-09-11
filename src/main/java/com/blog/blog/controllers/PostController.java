package com.blog.blog.controllers;

import com.blog.blog.Post;
import com.blog.blog.services.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {
    private final PostService postService = new PostService();

    public PostController() {
    }

    @GetMapping("/posts")
    private String postsIndexPage(Model viewModel) {
        viewModel.addAttribute("posts", postService.findAll());
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    private String postsIndividualPage(@PathVariable long id, Model viewModel) {
        viewModel.addAttribute("post", postService.findOne(id));
        return "posts/show";
    }

    @GetMapping("/posts/create")
    private String postsCreateViewPage(Model viewModel) {
        viewModel.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    private String postsCreateSendPage(
            @RequestParam(name = "title") String title,
            @RequestParam(name = "body") String body) {
        addPost(title, body);
        return "redirect:/posts";
    }

    @GetMapping("/posts/{id}/edit")
    private String postsEditViewPage(@PathVariable long id,Model viewModel) {
        viewModel.addAttribute("post", postService.findOne(id));
        return "posts/create";
    }

    @PostMapping("/posts/{id}/edit")
    private String postsEditSendPage(
            @RequestParam(name = "title") String title,
            @RequestParam(name = "body") String body) {
        addPost(title, body);
        return "redirect:/posts";
    }

    private Long addPost(String title, String body) {
        return postService.save(new Post(title, body)).getId();
    }
}
