package com.test.trading.tradingValidatorService.errors.impl;

import com.test.trading.tradingValidatorService.errors.ErrorMessage;

public class ValueDateBeforeTradeDateError implements ErrorMessage {

	@Override
	public String getErrorMessage() {
		return "value date cannot be before tradedate";
	}

}
