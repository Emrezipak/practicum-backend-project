package com.spring.project.repository;

import com.spring.project.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

    boolean existsById(Long userId);
}
