package com.test.trading.tradingValidatorService.errors.impl;

import com.test.trading.tradingValidatorService.errors.ErrorMessage;

public class NotSupportedStyleError implements ErrorMessage {

	@Override
	public String getErrorMessage() {
		
		return "Style Can be American or Europen only";
	}

}
