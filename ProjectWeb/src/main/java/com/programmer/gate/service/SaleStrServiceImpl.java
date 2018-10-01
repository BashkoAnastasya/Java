package com.programmer.gate.service;
import com.programmer.gate.service.SaleStrService;
import com.programmer.gate.domain.Ware;
import com.programmer.gate.domain.Sale;
import com.programmer.gate.domain.SaleStr;
import com.programmer.gate.repos.SaleStrRepo;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SaleStrServiceImpl implements SaleStrService {
	
	private SaleStrRepo repository;
	@Autowired
	public void setProductRepository(SaleStrRepo repository) {
		this.repository = repository;
	}
	@Override
	public SaleStr getSaleStrById(Integer id) {		
		return repository.findById(id).orElse(new SaleStr());
	}
	@Override
	public void saveSaleStr(SaleStr SaleStr) {
		repository.save(SaleStr);
		
	}
	@Override
	public void updateSaleStr(Integer id, String num, Integer qty, Ware ware, Sale sale,BigDecimal discount) {
		SaleStr saleStrUpdate= repository.findById(id).orElse(new SaleStr());
		saleStrUpdate.setNum(num);
	    saleStrUpdate.setQty(qty);
		saleStrUpdate.setWare(ware);
		saleStrUpdate.setSale(sale);
		saleStrUpdate.setDiscount(discount);
		repository.save(saleStrUpdate);
	}
	
	@Override
	public void deleteSaleStr(Integer id) {
		repository.deleteById(id);
		
	}
	@Override
	public List<SaleStr> findAll() {		
		return repository.findAll();
	}
		
	
	

}
