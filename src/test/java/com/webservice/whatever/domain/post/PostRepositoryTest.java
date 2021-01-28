package com.webservice.whatever.domain.post;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostRepositoryTest {
    @Autowired
    PostRepository postRepository;
    
    @After
    public void cleanUp(){
        postRepository.deleteAll();
    }
    
    @Test
    public void Post저장_불러오기(){
        //given
        String content = "테스트 본문";
        String author = "테스트 작성자";
        Post pre_post = Post.builder().content(content).author(author).build();

        postRepository.save(pre_post);

        //when
        List<Post> postList = postRepository.findAll();

        //then
        Post post = postList.get(0);
        //post자체는 다르므로 내용으로 비교해야 한다
        assertThat(post.getAuthor()).isEqualTo(pre_post.getAuthor());
        assertThat(post.getContent()).isEqualTo(pre_post.getContent());
    }
}