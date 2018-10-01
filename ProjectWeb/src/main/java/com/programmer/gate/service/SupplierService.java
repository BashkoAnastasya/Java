package com.programmer.gate.service;
import com.programmer.gate.domain.Supplier;

import java.util.List;

public interface SupplierService {
	
	   Supplier getSupplierById(Integer id);
	   void saveSupplier(Supplier supplier);
	   void updateSupplier(Integer id, String name,String moniker);
	   void deleteSupplier (Integer id);	   
	   List<Supplier> findAll();
	   List<Supplier> findByName(String name);
	   List<Supplier> filter(String name,String moniker);
}


