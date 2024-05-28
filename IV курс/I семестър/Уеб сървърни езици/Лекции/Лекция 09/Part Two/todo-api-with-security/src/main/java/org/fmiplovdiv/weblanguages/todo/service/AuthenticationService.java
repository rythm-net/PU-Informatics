package org.fmiplovdiv.weblanguages.todo.service;

import org.fmiplovdiv.weblanguages.todo.dto.JwtAuthenticationResponse;
import org.fmiplovdiv.weblanguages.todo.dto.SignInRequest;
import org.fmiplovdiv.weblanguages.todo.dto.SignUpRequest;

public interface AuthenticationService {
	JwtAuthenticationResponse signup(SignUpRequest request);

	JwtAuthenticationResponse signin(SignInRequest request);
}
