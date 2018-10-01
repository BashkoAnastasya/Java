package com.programmer.gate.repos;

import org.springframework.data.repository.CrudRepository;

import com.programmer.gate.domain.SaleStr;

import java.util.List;


public interface SaleStrRepo extends CrudRepository<SaleStr, Integer> {
	
	List <SaleStr> findAll();

}
