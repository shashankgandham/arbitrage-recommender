package com.citibridge.arbitragerecommendation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.citibridge.arbitragerecommendation.login_entities.User;
import com.citibridge.arbitragerecommendation.repositories.UserRepository;
import com.citibridge.arbitragerecommendation.services.LoginService;

@RestController
public class UserController {
	@Autowired
	UserRepository userRepository;
	@Autowired
	LoginService loginService;

	@PostMapping("/signup")
	public void signup(@RequestBody User user) {
		userRepository.save(user);
	}

	@PostMapping("/login")
	public String login(@RequestParam String email, @RequestParam String password) {
		if (loginService.authenticate(email, password)) {
			return "Successfull!!";
		} else {
			return "Failed!";
		}
	}

}
