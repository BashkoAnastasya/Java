package com.programmer.gate.repos;
import org.springframework.data.repository.CrudRepository;

import com.programmer.gate.domain.Supplier;

import java.util.List;
import java.util.Optional;


public interface SupplierRepo extends CrudRepository<Supplier, Integer> {
   
	List<Supplier> findByName(String name);
	List<Supplier> findAll();
	Optional<Supplier> findById(Integer id);

}