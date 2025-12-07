package com.jabar.wedding;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/posts")
public class PostController {
    private final PostService service;

    @PostMapping
    public Post save(PostDto request) {
        return service.save(request);
    }

    @PostMapping
    public List<Post> getAll() {
        return service.getAllPost();
    }

    @PostMapping("/{id}")
    public Post getById(@PathVariable Long id) {
        return service.getPostById(id);
    }
}
