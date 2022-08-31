package com.spring.project.controller;

import com.spring.project.entity.Comment;
import com.spring.project.payload.request.CommentRequest;
import com.spring.project.payload.response.CommentResponse;
import com.spring.project.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/comment")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/addComment")
    public ResponseEntity<CommentResponse> addComment(@Valid @RequestBody CommentRequest commentRequest){
        return ResponseEntity.ok(commentService.addComment(commentRequest));
    }

    @GetMapping("/getAllComment")
    public ResponseEntity<List<Comment>> getAllComment(){
        return ResponseEntity.ok(commentService.getAllComment());
    }

    @GetMapping("/getAllCommentsByProductId")
    public ResponseEntity<List<Comment>> getAllCommentsByProductId(@RequestParam(name = "productId") Long productId){
        return ResponseEntity.ok(commentService.getAllCommentsByProductId(productId));
    }

    @GetMapping("/getAllCommentByCommentDate/{productId}")
    public ResponseEntity<List<Comment>> getAllCommentByCommentDate(@DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss") @RequestParam(name ="startDate") LocalDateTime start,
                                                                    @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss") @RequestParam(name = "finishDate") LocalDateTime finish,
                                                                    @PathVariable Long productId){
        return ResponseEntity.ok(commentService.getAllCommentByCommentDateAndProductId(productId,start,finish));
    }

    @GetMapping("/getAllCommentByUserId/{userId}")
    public ResponseEntity<List<Comment>> getAllCommentByUserId(@PathVariable Long userId){
        return ResponseEntity.ok(commentService.getAllCommentByUserId(userId));
    }

    @GetMapping("/getAllCommentByCommentDate")
    public ResponseEntity<List<Comment>> getAllCommentsOfUserByCommentDate(@DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss") @RequestParam(name ="startDate") LocalDateTime start,
                                                                    @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss") @RequestParam(name = "finishDate") LocalDateTime finish,
                                                                    @RequestParam(name = "userId") Long userId){
        return ResponseEntity.ok(commentService.getAllCommentsOfUserByCommentDate(userId,start,finish));
    }

}
