package com.jabar.wedding;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
@Slf4j
public class PostService {
    private final PostRepository repository;

    public Post save(PostDto request) {
        log.info("Request: {}", request);
        var entity = new Post();
        entity.setName(request.name());
        entity.setStatus(request.status());
        entity.setComment(request.comment());
        entity.setCreatedAt(LocalDateTime.now());
        return repository.save(entity);
    }

    public Page<Post> getAllPost(int pageNo, int pageSize) {
        var sort = Sort.by(Sort.Direction.DESC, "createdAt");
        var pageable = PageRequest.of(pageNo, pageSize, sort);
        return repository.findAll(pageable);
    }

    public Post getPostById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Comment not found"));
    }
}
