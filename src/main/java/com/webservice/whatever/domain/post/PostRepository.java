package com.webservice.whatever.domain.post;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

//Dao로 쓰이는 DBLayer 접근자
//CRUD Method 자동 생성
//Post 클래스로 Database를 접근하게 해 줄 JpaRepository
public interface PostRepository extends JpaRepository<Post, Long> {
    @Query("SELECT p FROM Post p ORDER BY p.id DESC")
    List<Post> findAllDesc();
}
