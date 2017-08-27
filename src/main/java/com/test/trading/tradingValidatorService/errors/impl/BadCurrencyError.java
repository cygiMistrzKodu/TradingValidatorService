package com.test.trading.tradingValidatorService.errors.impl;

import com.test.trading.tradingValidatorService.components.TransactionFiled;
import com.test.trading.tradingValidatorService.components.impl.TransactionFiledImpl;
import com.test.trading.tradingValidatorService.errors.ErrorMessage;
import com.test.trading.tradingValidatorService.helpers.TransactionFileds;

public class BadCurrencyError implements ErrorMessage {

	private TransactionFileds currencyField;
	private String badCurrencyCode;

	private TransactionFiled transactionFiled = new TransactionFiledImpl();

	public BadCurrencyError(TransactionFileds currencyField, String badCurrencyCode) {

		this.currencyField = currencyField;
		this.badCurrencyCode = badCurrencyCode;

	}

	@Override
	public String getErrorMessage() {

		return "Bad currency code for field: " + transactionFiled.getFiledName(currencyField) + " illegal code: "
				+ badCurrencyCode;
	}

}
