package com.webservice.whatever.service;

import com.webservice.whatever.domain.post.Post;
import com.webservice.whatever.domain.post.PostRepository;
import com.webservice.whatever.web.dto.PostListResponseDto;
import com.webservice.whatever.web.dto.PostResponseDto;
import com.webservice.whatever.web.dto.PostSaveRequestDto;
import com.webservice.whatever.web.dto.PostUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;

    public Long save(PostSaveRequestDto requestDto){
        return postRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostUpdateRequestDto requestDto){
        Post post = postRepository.findById(id).orElseThrow(()->
                new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));
        post.update(requestDto.getContent());
        return id;
    }

    public PostResponseDto findById(Long id){
        Post entity = postRepository.findById(id).orElseThrow(()->
                new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));
        return new PostResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<PostListResponseDto> findAllDesc(){
        //repository에서 전부 찾아다가 map, toList로
        return postRepository.findAllDesc().stream()
                .map(PostListResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public void delete(Long id){
        Post posts = postRepository.findById(id).orElseThrow(()-> new
                IllegalArgumentException("해당 포스트가 없습니다. id=" + id));
        postRepository.delete(posts);
    }

}
