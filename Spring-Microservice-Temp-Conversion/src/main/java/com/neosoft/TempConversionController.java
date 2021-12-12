package com.neosoft;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TempConversionController {
	
	@Autowired
	private TempExchangeProxy proxy;
	
	@GetMapping("/temp-conversion/from/{from}/to/{to}/value/{value}")
	public TempConversion calculateTempConversion(@PathVariable String from, 
			@PathVariable String to,
			@PathVariable BigDecimal value) {
		
		TempConversion tempConversion = proxy.getExchangeValues(from, to);
		BigDecimal totalValue;
		if(from.equals("dg")) {
			totalValue = value.multiply(tempConversion.getConversionMultiple()).add(BigDecimal.valueOf(32));
		} else {
			totalValue = value.subtract(BigDecimal.valueOf(32)).multiply(tempConversion.getConversionMultiple());
		}
		
		return new TempConversion(tempConversion.getId(), from, to, value,
				tempConversion.getConversionMultiple(),
				totalValue,
				tempConversion.getEnvironment()+" "+"rest template");
	}
	
}
