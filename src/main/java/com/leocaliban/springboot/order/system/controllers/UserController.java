package com.leocaliban.springboot.order.system.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leocaliban.springboot.order.system.entities.User;

@RestController
@RequestMapping(value = "/users")
public class UserController {

	@GetMapping
	public ResponseEntity<User> getAll() {
		User u = User.builder().id(1L).name("Jack").password("6876").phone("95989599898").build();
		return ResponseEntity.ok().body(u);
	}
}
