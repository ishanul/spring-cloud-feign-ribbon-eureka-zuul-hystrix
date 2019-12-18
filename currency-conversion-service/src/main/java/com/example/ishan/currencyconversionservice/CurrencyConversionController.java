package com.example.ishan.currencyconversionservice;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CurrencyConversionController {

	@Autowired
	private CurrencyExchangeServiceProxy proxy;
	
	@GetMapping("currency-converter/from/{from}/to/{to}/quantity/{quantity}")
	public ConvertedValue retrieveConvertedValue(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {
		
		Map<String, String> variables = new HashMap<>();
		variables.put("from", "USD");
		variables.put("to", "LKR");
		ResponseEntity<ConvertedValue> responseEntity = new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}", ConvertedValue.class, variables);
		
		ConvertedValue response = responseEntity.getBody();
	
		
		return new ConvertedValue(from, to, quantity,response.getRate(),quantity.multiply(response.getRate()));
	}
	
	@GetMapping("currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}")
	public ConvertedValue retrieveConvertedValueFeign(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {
		
		
		ConvertedValue response = proxy.retrieveExchangeValue(from, to);
	
		
		return new ConvertedValue(from, to, quantity,response.getRate(),quantity.multiply(response.getRate()));
	}
}
