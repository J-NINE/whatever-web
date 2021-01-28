package com.webservice.whatever.domain.post;

import com.webservice.whatever.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity //table과 링크됨을 명시. 모든 필드는 명시 없이도 컬럼이 된다
public class Post extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @Column(nullable = false)
    private String author;

    @Builder
    public Post(String content, String author){
        this.content = content;
        this.author = author;
    }

    public void update(String content){
        this.content = content;
    }
}
