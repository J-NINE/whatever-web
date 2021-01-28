package com.webservice.whatever.web.dto;

import com.webservice.whatever.domain.post.Post;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostSaveRequestDto {
    private String author;
    private String content;

    @Builder
    public PostSaveRequestDto(String author, String content){
        this.author = author;
        this.content = content;
    }

    public Post toEntity(){
        return Post.builder()
        .content(content)
        .author(author)
        .build();
    }
}
