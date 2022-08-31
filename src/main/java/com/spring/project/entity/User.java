package com.spring.project.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(max = 50)
    private String name;
    @Size(max = 50)
    private String surname;
    @Size(max = 50)
    @Email
    private String email;
    @Size(max = 15)
    private String phoneNumber;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "product")
    private List<Comment> comments;
}
