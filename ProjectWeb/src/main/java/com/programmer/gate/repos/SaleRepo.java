package com.programmer.gate.repos;
import org.springframework.data.repository.CrudRepository;

import com.programmer.gate.domain.Sale;



import java.util.Optional;


public interface SaleRepo extends CrudRepository<Sale, Integer> {
			   
	Optional<Sale> findById(Integer id);	
	
}