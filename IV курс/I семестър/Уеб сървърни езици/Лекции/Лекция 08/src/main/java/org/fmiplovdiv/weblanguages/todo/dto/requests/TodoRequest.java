package org.fmiplovdiv.weblanguages.todo.dto.requests;

public record TodoRequest(
		Long id,
		String task,
		String description,
		Long teamMember
		) {

}
