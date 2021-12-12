package com.neosoft;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TempConversion {
	
	private Long id;
	
	private String from;
	
	private String to;
	
	private BigDecimal value;
	
	private BigDecimal conversionMultiple;
	
	private BigDecimal CalculatedTemp;
	
	private String environment;
}
