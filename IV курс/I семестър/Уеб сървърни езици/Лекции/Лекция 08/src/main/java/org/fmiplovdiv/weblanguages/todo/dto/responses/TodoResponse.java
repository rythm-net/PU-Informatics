package org.fmiplovdiv.weblanguages.todo.dto.responses;

public record TodoResponse(
		Long id,
		String task,
		String description,
		Integer todoStatus,
		Long teamMember
		) {

}
