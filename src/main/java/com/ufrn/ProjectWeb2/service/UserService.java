package com.ufrn.ProjectWeb2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ufrn.ProjectWeb2.model.User;
import com.ufrn.ProjectWeb2.repository.UserRepository;


@RestController
public class UserService {

	@Autowired
	private UserRepository ur;
	
	@RequestMapping("/user")
	public List<User> getUser() {
		return (List<User>) ur.findAll();
	}

	@PostMapping("/user")
	public User newUser(@RequestBody User um) {
		return ur.save(um);
	}

	@PutMapping("/user/{id}")
	public User updateUser(@RequestBody User newUser, @PathVariable Long id) {
		return ur.findById(id).map(user -> {
			user.setName(newUser.getName());
			user.setPassword(newUser.getPassword());
			return ur.save(user);
		}).orElseGet(() -> {
			newUser.setId(id);
			return ur.save(newUser);
		});
	}

	
	@DeleteMapping("/user/{id}")
	public void deleteUser(@PathVariable Long id) {
	    ur.delete(new User(id));
	}
	
}
