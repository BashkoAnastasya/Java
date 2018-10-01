package com.programmer.gate.repos;

import org.springframework.data.repository.CrudRepository;

import com.programmer.gate.domain.SupplyStr;

import java.util.List;


public interface SupplyStrRepo extends CrudRepository<SupplyStr, Integer> {
	
	List <SupplyStr> findAll();

}
