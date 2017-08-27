package com.test.trading.tradingValidatorService.components;

import java.time.LocalDate;

public interface NonWorkingDayChecker {
	
	 Boolean check(LocalDate date);

}
