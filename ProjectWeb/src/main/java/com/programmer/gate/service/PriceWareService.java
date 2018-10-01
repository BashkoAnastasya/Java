package com.programmer.gate.service;
import com.programmer.gate.domain.PriceWare;
import com.programmer.gate.domain.Ware;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface PriceWareService {
	
	   PriceWare getPriceWareById(Integer id);
	   void savePriceWare(PriceWare priceWare);
	   void updatePriceWare(Integer id, Date dbeg,Date dend,BigDecimal price,Ware ware);
	   void deletePriceWare (Integer id);	   
	   List<PriceWare> findAll();

}


