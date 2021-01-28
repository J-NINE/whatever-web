package com.webservice.whatever.web;

import com.webservice.whatever.domain.post.Post;
import com.webservice.whatever.service.PostService;
import com.webservice.whatever.web.dto.PostListResponseDto;
import com.webservice.whatever.web.dto.PostResponseDto;
import com.webservice.whatever.web.dto.PostSaveRequestDto;
import com.webservice.whatever.web.dto.PostUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PostApiController {
    private final PostService postService;

    //dto를 객체로 받아서 save()기능을 return
    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping("/api/v1/post")
    public Long save(@RequestBody PostSaveRequestDto requestDto){
        return postService.save(requestDto);
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @PutMapping("/api/v1/post/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostUpdateRequestDto requestDto){
        return postService.update(id, requestDto);
    }

    @GetMapping("/api/v1/post/{id}")
    public PostResponseDto findById(@PathVariable Long id){
        return postService.findById(id);
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("/api/board")
    public List<PostListResponseDto> boardList(Model model){
        return postService.findAllDesc();
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @DeleteMapping("/api/v1/post/{id}")
    public Long delete(@PathVariable Long id){
        postService.delete(id);
        return id;
    }

}
