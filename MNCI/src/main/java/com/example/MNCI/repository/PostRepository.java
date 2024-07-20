package com.example.MNCI.repository;

import com.example.MNCI.model.Community;
import com.example.MNCI.model.Post;
import com.example.MNCI.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllByCommunity(Community community);

    List<Post> findByUser(User user);
}
