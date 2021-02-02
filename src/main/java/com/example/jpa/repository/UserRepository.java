package com.example.jpa.repository;

import com.example.jpa.vo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findById(String userId);
    List<User> findByNameLike(String keyword);
}
