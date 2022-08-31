package com.spring.project.payload.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.spring.project.entity.Comment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommentResponse {

    private Comment comment;
    private String message;
    private boolean isError;
}
