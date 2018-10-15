package com.programmer.gate.repos;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.programmer.gate.domain.RestHist;


public interface RestHistRepo extends CrudRepository<RestHist, Integer> {
   	
	List<RestHist> findAll();
	Optional<RestHist> findById(Integer id);
	/**

	 * Filtering Rest

	 */	
	@Query("select c from RestHist c, Ware w where c.ware=w.id and w.name like %?1%  and c.dbeg>=?2 and c.dend<=?3")
	List <RestHist> filter(String wareName,Date dbeg, Date dend);
	
}