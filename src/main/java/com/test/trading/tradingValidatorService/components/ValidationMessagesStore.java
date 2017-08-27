package com.test.trading.tradingValidatorService.components;

import com.test.trading.tradingValidatorService.errors.ErrorMessage;

public interface ValidationMessagesStore {

	String getCurrentTransaction();

	void setCurrentTransaction(String currentTransaction);
	
	int getCurrentTransactionNumber();
	
	void setCurrentTransactionNumber(int currentTransactionNumber);
	
	void appendError(ErrorMessage errorMessage);	
	
	void createMeesage();
	
	String getValidationSummary();

}
