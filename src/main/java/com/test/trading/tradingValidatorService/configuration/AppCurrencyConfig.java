package com.test.trading.tradingValidatorService.configuration;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import com.test.trading.tradingValidatorService.components.Currencies;
import com.test.trading.tradingValidatorService.components.impl.CurrenciesSet;

@Configuration
public class AppCurrencyConfig {

	@Value(value = "classpath:ISO_4217.xml")
	private Resource currenciesXml;

	@Bean
	public Currencies getCurrencies() {

		Currencies currencies = new CurrenciesSet();

		try {
			File iso_4217File = currenciesXml.getFile();
			currencies.readCurrencyCodeFromFile(iso_4217File);

		} catch (IOException e) {
			e.printStackTrace();
		}

		return currencies;
	}

}
