package com.programmer.gate.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.programmer.gate.domain.PriceWare;

public interface PriceWareRepo extends CrudRepository<PriceWare, Integer> {
	List<PriceWare> findAll();

}
