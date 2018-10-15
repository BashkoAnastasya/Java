package com.programmer.gate.service;

import java.math.BigDecimal;
import java.util.List;



import com.programmer.gate.domain.Sale;
import com.programmer.gate.domain.SaleStr;
import com.programmer.gate.domain.Ware;

public interface SaleStrService {
    	SaleStr getSaleStrById(Integer id);
	   void saveSaleStr(SaleStr saleStr);
	   void updateSaleStr(Integer id, String num, Integer qty, Ware ware,Sale Sale, BigDecimal discount);
	   void deleteSaleStr (Integer id);
	   List<SaleStr> findAll();	
	   List<SaleStr> findBySale(Sale sale);
}
