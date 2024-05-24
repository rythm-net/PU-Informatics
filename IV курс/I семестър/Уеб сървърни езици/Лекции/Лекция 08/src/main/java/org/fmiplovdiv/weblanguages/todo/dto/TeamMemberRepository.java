package org.fmiplovdiv.weblanguages.todo.dto;

import org.fmiplovdiv.weblanguages.todo.model.TeamMember;
import org.springframework.data.repository.ListCrudRepository;

public interface TeamMemberRepository extends ListCrudRepository<TeamMember, Long> {
	
}
