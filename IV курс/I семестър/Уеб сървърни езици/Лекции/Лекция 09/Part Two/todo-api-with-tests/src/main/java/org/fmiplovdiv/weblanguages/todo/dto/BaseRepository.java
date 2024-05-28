package org.fmiplovdiv.weblanguages.todo.dto;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRepository<T, ID> extends ListCrudRepository<T, ID>{

	
}
