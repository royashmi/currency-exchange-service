package com.project.microservices.currencyexchangeservice;

import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class CurrencyExchangeController {
	@Autowired private Environment environment;

	@GetMapping(
		"/currency-exchange/fromCurrency/{fromCurrency}/toCurrency/{toCurrency}")
	public ExchangeValue
	retrieveExchangeValue(@PathVariable String fromCurrency,
						@PathVariable String toCurrency)
	{
		BigDecimal conversionMultiple = null;
		ExchangeValue exchangeValue = new ExchangeValue();
		if (fromCurrency != null && toCurrency != null) {
			if (fromCurrency.equalsIgnoreCase("USD")
				&& toCurrency.equalsIgnoreCase("INR")) {
				conversionMultiple = BigDecimal.valueOf(82);
			}
			if (fromCurrency.equalsIgnoreCase("INR")
				&& toCurrency.equalsIgnoreCase("USD")) {
				conversionMultiple
					= BigDecimal.valueOf(0.012);
			}
			if (fromCurrency.equalsIgnoreCase("EUR")
				&& toCurrency.equalsIgnoreCase("INR")) {
				conversionMultiple = BigDecimal.valueOf(90);
			}
			if (fromCurrency.equalsIgnoreCase("AUD")
				&& toCurrency.equalsIgnoreCase("INR")) {
				conversionMultiple = BigDecimal.valueOf(55);
			}
		}
		
		int port = Integer.parseInt(
			environment.getProperty("server.port"));
		exchangeValue = new ExchangeValue(
				1000L, fromCurrency, toCurrency,
				conversionMultiple, port);
		return exchangeValue;
	}
}

