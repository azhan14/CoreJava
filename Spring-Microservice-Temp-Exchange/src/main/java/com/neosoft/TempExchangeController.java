package com.neosoft;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TempExchangeController {
	
	@Autowired
	private Environment environment;
	
	@Autowired
	private TempExchangeRepository tempExchangeRepository;
	
	@GetMapping("/temp-exchange/from/{from}/to/{to}")
	public TempExchange getExchangeValue(@PathVariable String from,
			@PathVariable String to) {
		TempExchange object = tempExchangeRepository.findByFromAndTo(from, to);
		if(object == null)
			throw new RuntimeException("unable to find data for : "+from+" to " +to);
		String port = environment.getProperty("local.server.port");
		object.setEnvironment(port);
		return object;
	}
}
