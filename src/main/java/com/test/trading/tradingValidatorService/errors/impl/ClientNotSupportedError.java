package com.test.trading.tradingValidatorService.errors.impl;

import com.test.trading.tradingValidatorService.errors.ErrorMessage;

public class ClientNotSupportedError implements ErrorMessage {

	private String customerName;
	
	public ClientNotSupportedError(String customerName ) {
		this.customerName = customerName;
	}

	@Override
	public String getErrorMessage() {
		return "Client: " + customerName + " not supported";
	}

}
