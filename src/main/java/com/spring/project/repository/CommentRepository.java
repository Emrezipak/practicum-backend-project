package com.spring.project.repository;

import com.spring.project.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> getAllByProduct_Id(Long id);
    List<Comment> getAllByProduct_IdAndCommentDateBetween(Long product_id, LocalDateTime startDate, LocalDateTime finishDate);
    List<Comment> getAllByUser_IdAndCommentDateBetween(Long user_id, LocalDateTime startDate, LocalDateTime finishDate);

    List<Comment> getAllCommentByUser_Id(Long userId);

    boolean existsById(Long commentId);
}
