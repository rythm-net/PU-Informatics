package org.fmiplovdiv.weblanguages.todo.service;

import org.fmiplovdiv.weblanguages.todo.dto.TeamMemberRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
	private final TeamMemberRepository teamMemberRepository;

	public UserServiceImpl(TeamMemberRepository teamMemberRepository) {
		super();
		this.teamMemberRepository = teamMemberRepository;
	}

	@Override
	public UserDetailsService userDetailsService() {
		return new UserDetailsService() {
			@Override
			public UserDetails loadUserByUsername(String username) {
				return teamMemberRepository.findByName(username)
						.orElseThrow(() -> new UsernameNotFoundException("User not found"));
			}
		};
	}
}
