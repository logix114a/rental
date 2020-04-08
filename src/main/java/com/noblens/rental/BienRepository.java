package com.noblens.rental;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

public interface BienRepository extends CrudRepository<Bien, Long>{

	Iterable<Bien> findAll(Sort test);
	
}
