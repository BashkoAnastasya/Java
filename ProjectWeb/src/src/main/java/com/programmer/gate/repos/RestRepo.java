package com.programmer.gate.repos;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.programmer.gate.domain.Rest;

public interface RestRepo extends CrudRepository<Rest, Integer> {
   	
	List<Rest> findAll();
	Optional<Rest> findById(Integer id);
	/**

	 * Filtering Rest

	 */	
	@Query("select c from Rest c,Ware w where w.id=c.ware and  w.name like %?1% " )
	List <Rest> filter(String ware);
	
}