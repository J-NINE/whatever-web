package com.webservice.whatever.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostUpdateRequestDto {
    private String author;
    private String content;

    @Builder
    public PostUpdateRequestDto(String author, String content){
        this.author = author;
        this.content = content;
    }


}
