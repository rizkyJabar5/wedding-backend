package com.jabar.wedding;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
@Log4j
public class PostService {
    private final PostRepository repository;

    public Post save(PostDto request) {
        var entity = new Post();
        entity.setName(request.name());
        entity.setStatus(request.status());
        entity.setComment(request.comment());
        return repository.save(entity);
    }

    public List<Post> getAllPost() {
        return repository.findAll();
    }

    public Post getPostById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Comment not found"));
    }
}
