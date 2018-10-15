package com.programmer.gate.repos;

import org.springframework.data.repository.CrudRepository;

import com.programmer.gate.domain.Sale;
import com.programmer.gate.domain.SaleStr;

import java.util.List;
import java.util.Optional;


public interface SaleStrRepo extends CrudRepository<SaleStr, Integer> {
	
	List <SaleStr> findAll();
	Optional<SaleStr> findById(Integer id);	
	List <SaleStr> findBySale(Sale sale);

}
