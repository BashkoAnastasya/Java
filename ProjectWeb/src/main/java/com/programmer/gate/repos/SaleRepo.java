package com.programmer.gate.repos;
import org.springframework.data.repository.CrudRepository;

import com.programmer.gate.domain.Sale;

import java.util.List;
import java.util.Optional;


public interface SaleRepo extends CrudRepository<Sale, Integer> {
			   
	List<Sale> findByClientId(Integer clientId);
	Optional<Sale> findById(Integer id);	
	
}