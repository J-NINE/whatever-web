package com.webservice.whatever.web.dto;

import com.webservice.whatever.domain.post.Post;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostListResponseDto {
    private Long id;
    private String author;
    private String content;
    private LocalDateTime modifiedDate;

    public PostListResponseDto(Post entity){
        this.id = entity.getId();
        this.author = entity.getAuthor();
        this.content = entity.getContent();
        this.modifiedDate = entity.getModifiedDate();
    }
}
