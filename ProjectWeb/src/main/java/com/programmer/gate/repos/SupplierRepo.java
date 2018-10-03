package com.programmer.gate.repos;
import org.springframework.data.repository.CrudRepository;

import com.programmer.gate.domain.Supplier;

import org.springframework.data.jpa.repository.Query;


import java.util.List;
import java.util.Optional;

public interface SupplierRepo extends CrudRepository<Supplier, Integer> {
   
	List<Supplier> findByName(String name);
	List<Supplier> findAll();
	Optional<Supplier> findById(Integer id);
	
	/**

	 * Filtering Supplier

	 */
	
	@Query("select c from Supplier c where c.name like %?1 and c.moniker like %?2")
	List <Supplier> findByNameAndMoniker(String name,String moniker);

}