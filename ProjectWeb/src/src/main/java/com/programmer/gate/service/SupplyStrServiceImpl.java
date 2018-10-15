package com.programmer.gate.service;
import com.programmer.gate.service.SupplyStrService;
import com.programmer.gate.domain.Ware;
import com.programmer.gate.domain.Supply;
import com.programmer.gate.domain.SupplyStr;
import com.programmer.gate.repos.SupplyStrRepo;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SupplyStrServiceImpl implements SupplyStrService {
	
	private SupplyStrRepo repository;
	@Autowired
	public void setProductRepository(SupplyStrRepo repository) {
		this.repository = repository;
	}
	@Override
	public SupplyStr getSupplyStrById(Integer id) {		
		return repository.findById(id).orElse(new SupplyStr());
	}
	@Override
	public void saveSupplyStr(SupplyStr supplyStr) {
		repository.save(supplyStr);
		
	}
	@Override
	public void updateSupplyStr(Integer id, String num, BigDecimal price, Integer qty, Ware ware, Supply supply) {
		SupplyStr supplyStr= repository.findById(id).orElse(new SupplyStr());
		supplyStr.setNum(num);
		supplyStr.setPrice(price);
		supplyStr.setQty(qty);
		supplyStr.setWare(ware);
		supplyStr.setSupply(supply);
		repository.save(supplyStr);
	}
	
	@Override
	public void deleteSupplyStr(Integer id) {
		repository.deleteById(id);
		
	}
	@Override
	public List<SupplyStr> findAll() {		
		return repository.findAll();
	}
		
	
	

}
