package com.jabar.wedding;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/posts")
public class PostController {
    private final PostService service;

    @PostMapping
    public Post save(@RequestBody PostDto request) {
        return service.save(request);
    }

    @GetMapping
    public Page<Post> getAll(@RequestParam(defaultValue = "0") int pageNo,
                             @RequestParam(defaultValue = "10") int pageSize) {
        return service.getAllPost(pageNo, pageSize);
    }

    @GetMapping("/{id}")
    public Post getById(@PathVariable Long id) {
        return service.getPostById(id);
    }
}
