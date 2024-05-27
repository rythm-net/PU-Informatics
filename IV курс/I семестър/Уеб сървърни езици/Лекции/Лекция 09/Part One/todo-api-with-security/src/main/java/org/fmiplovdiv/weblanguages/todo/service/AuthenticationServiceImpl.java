package org.fmiplovdiv.weblanguages.todo.service;

import org.fmiplovdiv.weblanguages.todo.dto.JwtAuthenticationResponse;
import org.fmiplovdiv.weblanguages.todo.dto.SignInRequest;
import org.fmiplovdiv.weblanguages.todo.dto.SignUpRequest;
import org.fmiplovdiv.weblanguages.todo.dto.TeamMemberRepository;
import org.fmiplovdiv.weblanguages.todo.model.TeamMember;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService{
	private final TeamMemberRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	private final JwtService jwtService;
	private final AuthenticationManager authenticationManager;

	public AuthenticationServiceImpl(TeamMemberRepository userRepository, PasswordEncoder passwordEncoder,
			JwtService jwtService, AuthenticationManager authenticationManager) {
		super();
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
		this.jwtService = jwtService;
		this.authenticationManager = authenticationManager;
	}

	@Override
	public JwtAuthenticationResponse signup(SignUpRequest request) {
		var user = new TeamMember(request.getUsername(), passwordEncoder.encode(request.getPassword()));
		userRepository.save(user);
		var jwt = jwtService.generateToken(user);
		return new JwtAuthenticationResponse(jwt);
	}

	@Override
	public JwtAuthenticationResponse signin(SignInRequest request) {
		authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
		var user = userRepository.findByName(request.getUsername())
				.orElseThrow(() -> new IllegalArgumentException("Invalid email or password"));
		var jwt = jwtService.generateToken(user);
		return new JwtAuthenticationResponse(jwt);
	}
}
