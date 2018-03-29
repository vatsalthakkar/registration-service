package com.assignment.registrationservice;

import java.net.URI;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


@RestController
public class RegistrationController {

	@Autowired
	private Environment environment;
	@Autowired
	private UserRepository repository;
	@GetMapping("/retrieve/{username}")
	public User retrievUser(@PathVariable String username) {
		User user= repository.findByUsername(username);
		return user;
	}
	
	@GetMapping("/all")
	public List<User> getAllUser() {
		return repository.findAll();
	}
	
	@PostMapping("/register")
	public User registerUser(@RequestBody User user) {
		User savedUser=repository.save(user);
		/*URI location= ServletUriComponentsBuilder.fromUriString("localhost:"+ environment.
				getProperty("local.server.port") +"/retrieve").path("/{retrieve}").
			buildAndExpand(savedUser.getUsername()).toUri();*/
		//return ResponseEntity.created(location).build();
		return savedUser;
	}
	
	@GetMapping("/validate/{username}/{password}")
	public User validateUser(@PathVariable String username,@PathVariable String password){
		
		User returnedUser= repository.findByUsernameAndPassword(username,password);
		return returnedUser;
	}
}
