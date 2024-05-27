package org.fmiplovdiv.weblanguages.todo.dto;

import java.util.Optional;

import org.fmiplovdiv.weblanguages.todo.model.TeamMember;

public interface TeamMemberRepository extends BaseRepository<TeamMember, Long>{

	boolean existsById(Long id);
	Optional<TeamMember> findByName(String name);
}
