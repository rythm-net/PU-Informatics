package org.fmiplovdiv.weblanguages.todo.service;

import java.util.List;

import org.fmiplovdiv.weblanguages.todo.dto.TeamMemberRepository;
import org.fmiplovdiv.weblanguages.todo.model.TeamMember;
import org.springframework.stereotype.Service;

@Service
public class TeamMemberService {

	private final TeamMemberRepository teamMemberRepository;

	public TeamMemberService(TeamMemberRepository teamMemberRepository) {
		super();
		this.teamMemberRepository = teamMemberRepository;
	}
	
	public TeamMember createTeamMember(TeamMember toCreate) {
		if (toCreate.getName() == null) {
			return null;
		}
		
		toCreate = teamMemberRepository.save(toCreate);
		
		return toCreate;
	}
	
	public TeamMember getTeamMemberById(Long id) {
		return teamMemberRepository.findById(id).orElse(null);
	}
	
	public List<TeamMember> getAllTeamMembers() {
		return teamMemberRepository.findAll();
	}
}
