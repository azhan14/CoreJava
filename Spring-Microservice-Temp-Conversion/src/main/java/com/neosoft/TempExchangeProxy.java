package com.neosoft;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "temp-exchange")
public interface TempExchangeProxy {
	
	@GetMapping("temp-exchange/from/{from}/to/{to}")
	public TempConversion getExchangeValues(@PathVariable String from,
			@PathVariable String to);
}
