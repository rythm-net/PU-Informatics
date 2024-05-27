package org.fmiplovdiv.weblanguages.todo.controllers;

import org.fmiplovdiv.weblanguages.todo.dto.JwtAuthenticationResponse;
import org.fmiplovdiv.weblanguages.todo.dto.SignInRequest;
import org.fmiplovdiv.weblanguages.todo.dto.SignUpRequest;
import org.fmiplovdiv.weblanguages.todo.service.AuthenticationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/auth")
public class AuthenticationController {
	private final AuthenticationService authenticationService;

	public AuthenticationController(AuthenticationService authenticationService) {
		super();
		this.authenticationService = authenticationService;
	}

	@PostMapping("/signup")
	public ResponseEntity<JwtAuthenticationResponse> signup(@RequestBody SignUpRequest request) {
		return ResponseEntity.ok(authenticationService.signup(request));
	}

	@PostMapping("/signin")
	public ResponseEntity<JwtAuthenticationResponse> signin(@RequestBody SignInRequest request) {
		return ResponseEntity.ok(authenticationService.signin(request));
	}
}
