package com.spring.project.service;

import com.spring.project.entity.Comment;
import com.spring.project.entity.Product;
import com.spring.project.entity.User;
import com.spring.project.payload.request.CommentRequest;
import com.spring.project.payload.response.CommentResponse;
import com.spring.project.repository.CommentRepository;
import com.spring.project.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final ProductService productService;
    private final UserService userService;

    public List<Comment> getAllCommentsByProductId(Long productId){
        return commentRepository.getAllByProduct_Id(productId);
    }

    public CommentResponse addComment(CommentRequest commentRequest) {
        CommentResponse commentResponse = dtoComment(commentRequest);
        if(!commentResponse.isError()){
            commentRepository.save(commentResponse.getComment());
            return commentResponse;
        }
        return commentResponse;
    }

    public List<Comment> getAllCommentByCommentDateAndProductId(Long id,LocalDateTime start, LocalDateTime finish) {
        return commentRepository.getAllByProduct_IdAndCommentDateBetween(id,start,finish);
    }

    public List<Comment> getAllCommentByUserId(Long userId) {
        return commentRepository.getAllCommentByUser_Id(userId);
    }

    private CommentResponse dtoComment(CommentRequest commentRequest){
        Optional<Product> product = productService.getProductByProductId(commentRequest.getProductId());
        Optional<User> user = userService.getUserByUserId(commentRequest.getUserId());

        if(!product.isPresent()){
            return CommentResponse.builder().isError(true).message("Product not found").build();
        }
        else if(!user.isPresent()){
            return CommentResponse.builder().isError(true).message("User not found").build();
        }

       Comment comment = Comment.builder().
                commentText(commentRequest.getCommentText())
                .commentDate(commentRequest.getCommentDate())
                .user(user.get())
                .product(product.get()).build();

        return CommentResponse.builder().comment(comment).isError(false).message("Comment created successfully").build();
    }

    public List<Comment> getAllComment() {
        return commentRepository.findAll();
    }

    public List<Comment> getAllCommentsOfUserByCommentDate(Long userId, LocalDateTime start, LocalDateTime finish) {
        return commentRepository.getAllByUser_IdAndCommentDateBetween(userId,start,finish);
    }
}
