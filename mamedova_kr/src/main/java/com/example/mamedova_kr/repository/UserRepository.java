package com.example.mamedova_kr.repository;

import com.example.mamedova_kr.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
