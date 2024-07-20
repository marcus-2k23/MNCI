package com.example.MNCI.repository;

import com.example.MNCI.model.Comment;
import com.example.MNCI.model.Post;
import com.example.MNCI.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByPost(Post post);

    List<Comment> findAllByUser(User user);
}
