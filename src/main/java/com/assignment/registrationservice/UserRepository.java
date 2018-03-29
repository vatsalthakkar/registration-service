package com.assignment.registrationservice;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <User,String>{
	User findByUsername(String username);

	User findByUsernameAndPassword(String username, String password);

	User findByPassword(String password);
}
