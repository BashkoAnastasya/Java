package com.programmer.gate.service;
import com.programmer.gate.service.SupplyService;
import com.programmer.gate.domain.Supplier;
import com.programmer.gate.domain.Supply;
import com.programmer.gate.repos.SupplyRepo;
import com.programmer.gate.domain.State;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SupplyServiceImpl implements SupplyService{
	private SupplyRepo repository;

	@Autowired
	public void setProductRepository(SupplyRepo repository) {
		this.repository = repository;
	}
	
	@Override
	public Supply getSupplyById(Integer id) {		
		return repository.findById(id).orElse(new Supply());
	}

	@Override
	public void saveSupply(Supply supply) {
		 repository.save(supply);		
	}

	@Override
	public void updateSupply(Integer id, String num, String code, Date dt,Supplier supplier,State state) {
		Supply supplyUpdate=repository.findById(id).orElse(new Supply());
		supplyUpdate.setCode(code);
		supplyUpdate.setNum(num);
		supplyUpdate.setDt(dt);
		supplyUpdate.setSupplier(supplier);
		supplyUpdate.setState(state);
		repository.save(supplyUpdate);		
	}

	@Override
	public void deleteSupply(Integer id) {
		repository.deleteById(id);		
	}
	
	@Override
	public List<Supply> findAll() {	
		return (List<Supply>) repository.findAll();
	}
	

}
