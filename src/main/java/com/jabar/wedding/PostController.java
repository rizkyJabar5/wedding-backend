package com.jabar.wedding;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping
    public List<Post> getAll() {
        return service.getAllPost();
    }

    @GetMapping("/{id}")
    public Post getById(@PathVariable Long id) {
        return service.getPostById(id);
    }
}
