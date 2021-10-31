package com.poc2;

import java.util.List;

import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	public final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	@Autowired
	UserService userService;


	@GetMapping("/users")
	ResponseEntity<?> getUsers() {
		return ResponseEntity.ok(userService.getAllUsers());
	}
	
	@PostMapping("/user")
	@ResponseStatus(HttpStatus.CREATED)
	User createUser(@RequestBody User user) {
		return userService.saveUser(user);
	}
	
	
	@PutMapping("/user/{id}")
	String updateUser(@PathVariable("id") int id, @RequestBody User user) {
		return userService.updateUserById(user, id);
	}

	
	@GetMapping("/users/name")
	List<User> getUserByName(@RequestParam("q") String q) {
		return userService.findUsersByName(q);
	}

	
	@GetMapping("/sortusers")
	List<User> getSortedList() {
		return userService.findSortedList();
	}


	@DeleteMapping("/user/del/{id}")
	void deleteUser(@PathVariable("id") int id) {
		userService.deleteUserById(id);
	}
	
	
	@PutMapping("/user/deluser/{id}")
	void softDelete(@PathVariable("id") int id) {
		userService.softDelete(id);
	}
}
