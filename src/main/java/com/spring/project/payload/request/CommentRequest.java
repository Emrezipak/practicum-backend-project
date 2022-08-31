package com.spring.project.payload.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Lob;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommentRequest {

    @Lob
    @Size(min=1,max = 500)
    private String commentText;
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    @NotNull
    private LocalDateTime commentDate;
    @NotNull
    private Long productId;
    @NotNull
    private Long userId;
}
