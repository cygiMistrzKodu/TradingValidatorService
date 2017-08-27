package com.test.trading.tradingValidatorService.errors.impl;

import java.time.LocalDate;

import com.test.trading.tradingValidatorService.components.TransactionFiled;
import com.test.trading.tradingValidatorService.components.impl.TransactionFiledImpl;
import com.test.trading.tradingValidatorService.errors.ErrorMessage;
import com.test.trading.tradingValidatorService.helpers.TransactionFileds;

public class NonWorkindDayError implements ErrorMessage {
	
	LocalDate localDate;
	TransactionFileds dateField;
	
	private TransactionFiled transactionFiled = new TransactionFiledImpl();
	
	public NonWorkindDayError(TransactionFileds dateField ,LocalDate localDate) {
		
		this.dateField = dateField;
		this.localDate = localDate;
		
	}

	@Override
	public String getErrorMessage() {
		
		return "Day in filed: " + transactionFiled.getFiledName(dateField) + ": "+ localDate+ " is non-working day";
		
	}

}
