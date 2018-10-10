package com.programmer.gate.service;
import com.programmer.gate.domain.Rest;

import java.util.List;

public interface RestService {
	

	   List<Rest> findAll();	
	   List<Rest> filter(String ware);
}


