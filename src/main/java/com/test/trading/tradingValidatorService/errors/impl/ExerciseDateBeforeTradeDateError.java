package com.test.trading.tradingValidatorService.errors.impl;

import com.test.trading.tradingValidatorService.errors.ErrorMessage;

public class ExerciseDateBeforeTradeDateError implements ErrorMessage {

	@Override
	public String getErrorMessage() {
		return "Exercise date can not be before trade date";
	}

}
