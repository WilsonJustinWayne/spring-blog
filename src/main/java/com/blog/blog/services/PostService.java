package com.blog.blog.services;

import com.blog.blog.Post;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {
    private List<Post> posts;

    public PostService() {
        posts = new ArrayList<>();
        createPosts();
    }

    public List<Post> findAll() {
        return posts;
    }

    public Post findOne(long id) {
        return posts.get((int) id - 1);
    }

    public Post save(Post post) {
        post.setId(posts.size() + 1);
        posts.add(post);
        return post;
    }

    private void createPosts() {
        // create some post objects and add them to the posts list with the save method
        posts.add(new Post(
           posts.size() + 1,"Post1", "Body1"
        ));
        posts.add(new Post(
                posts.size() + 1,"Post2", "Body2"
        ));
        posts.add(new Post(
                posts.size() + 1,"Post3", "Body3"
        ));
        posts.add(new Post(
                posts.size() + 1,"Post4", "Body4"
        ));
        posts.add(new Post(
                posts.size() + 1,"Post5", "Body5"
        ));
    }
}