package com.programmer.gate.repos;
import org.springframework.data.repository.CrudRepository;

import com.programmer.gate.domain.Supply;

import java.util.List;
import java.util.Optional;


public interface SupplyRepo extends CrudRepository<Supply, Integer> {
			   
	List<Supply> findBySupplierId(Integer supplierId);
	Optional<Supply> findById(Integer id);
	
	
}