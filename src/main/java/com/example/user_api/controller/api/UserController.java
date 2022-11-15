package com.example.user_api.controller.api;

import javax.validation.Valid;

import com.example.user_api.controller.request.UserRequest;
import com.example.user_api.exception.ValidationException;
import com.example.user_api.model.User;
import com.example.user_api.service.UserService;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/auth")
@RestController
public class UserController {

	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping("/register")
	public User register(@Valid @RequestBody UserRequest userRequest, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			bindingResult.getFieldErrors().stream().forEach(fieldError -> {
				throw new ValidationException(fieldError.getField() + ": " + fieldError.getDefaultMessage());
			});
		}

		return userService.register(userRequest);
	}
}
