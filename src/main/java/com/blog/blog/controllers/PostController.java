package com.blog.blog.controllers;

import com.blog.blog.models.Post;
import com.blog.blog.models.User;
import com.blog.blog.repositories.PostsRepo;
import com.blog.blog.repositories.UsersRepo;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {
    private PostsRepo postsRepo;
    private UsersRepo usersRepo;

    public PostController(PostsRepo postsRepo, UsersRepo usersRepo) {
        this.postsRepo = postsRepo;
        this.usersRepo = usersRepo;
    }

    @GetMapping("/posts")
    private String postsIndexPage(Model viewModel) {
        viewModel.addAttribute("posts", postsRepo.findAll());
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    private String postsIndividualPage(@PathVariable long id, Model viewModel) {
        viewModel.addAttribute("post", postsRepo.findOne(id));
        return "posts/show";
    }

    @GetMapping("/posts/create")
    private String postsCreateViewPage(Model viewModel) {
        viewModel.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    private String postsCreateSendPage(
     @ModelAttribute Post post) {
        addPost(post);
        return "redirect:/posts";
    }

    @GetMapping("/posts/{id}/edit")
    private String postsEditViewPage(@PathVariable long id,Model viewModel) {
        viewModel.addAttribute("post", postsRepo.findOne(id));
        return "posts/create";
    }

    @PostMapping("/posts/{id}/edit")
    private String postsEditSendPage(@ModelAttribute Post post) {
        addPost(post);
        return "redirect:/posts";
    }

    private Long addPost(Post post) {
        post.setUser((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        return postsRepo.save(post).getId();
    }
}
