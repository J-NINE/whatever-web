package com.webservice.whatever.web.dto;

import com.webservice.whatever.domain.post.Post;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostResponseDto {

    private Long id;
    private String author;
    private String content;

    public PostResponseDto(Post entity){
        this.id = id;
        this.author = author;
        this.content = content;
    }
}
