package com.lennon.service.impl;

import org.springframework.stereotype.Service;

import com.lennon.model.Kalkulator;
import com.lennon.service.KalkulatorService;

@Service
public class KalkulatorServiceImpl implements KalkulatorService {

	public Integer count(Kalkulator kalkulator, String option) {
		
		Integer hasil = 0;
		
		switch (option) {
		case "":
			
			break;
		default:
			break;
		}
		
		return hasil;
	}

}
