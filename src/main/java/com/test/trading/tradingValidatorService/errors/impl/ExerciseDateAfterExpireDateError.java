package com.test.trading.tradingValidatorService.errors.impl;

import com.test.trading.tradingValidatorService.errors.ErrorMessage;

public class ExerciseDateAfterExpireDateError implements ErrorMessage {

	@Override
	public String getErrorMessage() {
		
		return "Exercise date can not be after expire date";
	}

}
