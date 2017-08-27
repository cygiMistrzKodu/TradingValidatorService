package com.test.trading.tradingValidatorService.components;

import java.time.LocalDate;

public interface DateParser {

	LocalDate parseToDate(String dateText);
}
