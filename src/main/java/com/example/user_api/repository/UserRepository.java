package com.example.user_api.repository;

import com.example.user_api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
	// select * from user where username = 'fool'
	User findByUsername(String username);
}
