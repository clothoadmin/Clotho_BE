package com.clotho.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clotho.project.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findByEmailAndPassword(String email, String password);
}
