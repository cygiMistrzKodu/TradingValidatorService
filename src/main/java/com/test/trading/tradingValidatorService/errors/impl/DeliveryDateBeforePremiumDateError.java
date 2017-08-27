package com.test.trading.tradingValidatorService.errors.impl;

import com.test.trading.tradingValidatorService.errors.ErrorMessage;

public class DeliveryDateBeforePremiumDateError implements ErrorMessage {

	@Override
	public String getErrorMessage() {
		return "Delivery date cannot be before premium date";
	}

}
