package com.test.trading.tradingValidatorService.components.impl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;

import com.test.trading.tradingValidatorService.components.DateParser;

@Component
public class DateParserImpl implements DateParser {
	
	DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	@Override
	public LocalDate parseToDate(String dateText) {
		
	 return	LocalDate.parse(dateText, dateTimeFormatter);

	}

}
