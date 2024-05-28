package org.fmiplovdiv.weblanguages.todo.dto;

import org.fmiplovdiv.weblanguages.todo.model.TeamMember;

public interface TeamMemberRepository extends BaseRepository<TeamMember, Long>{

	boolean existsById(Long id);
}
