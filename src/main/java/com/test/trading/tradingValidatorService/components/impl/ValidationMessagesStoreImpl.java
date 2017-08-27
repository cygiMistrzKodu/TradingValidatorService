package com.test.trading.tradingValidatorService.components.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.test.trading.tradingValidatorService.components.ValidationMessagesStore;
import com.test.trading.tradingValidatorService.errors.ErrorMessage;

@Component
public class ValidationMessagesStoreImpl implements ValidationMessagesStore {

	private List<String> validationMessagesSummary = new ArrayList<String>();
	private String currentTransaction;
	private int currentTransactionNumber;
	private StringBuilder errors = new StringBuilder(ERROR_PREFIX);
	private boolean isErrors = false;
	private final static String ERROR_PREFIX = "Errors : ";

	public String getCurrentTransaction() {
		return currentTransaction;
	}

	public void setCurrentTransaction(String currentTransaction) {
		this.currentTransaction = currentTransaction;
	}

	public int getCurrentTransactionNumber() {
		return currentTransactionNumber;
	}

	public void setCurrentTransactionNumber(int currentTransactionNumber) {
		this.currentTransactionNumber = currentTransactionNumber;
	}

	public void appendError(ErrorMessage errorMessage ) {
		errors.append(errorMessage.getErrorMessage() + " | ");
		isErrors = true;
	}

	public void createMeesage() {

		if (isErrors == false) {
			validationMessagesSummary.add("Transaction:[" + currentTransactionNumber + "] OK");
		}

		if (isErrors == true) {

			String message = "Transaction:[" + currentTransactionNumber + "] " + currentTransaction + "\n"
					+ errors.toString();
			validationMessagesSummary.add(message);

			isErrors = false;
			errors.setLength(0);
			errors.append(ERROR_PREFIX);

		}

	}

	public String getValidationSummary() {

		StringBuilder stringBuilder = new StringBuilder();
		validationMessagesSummary.forEach(t -> stringBuilder.append(t + "\n\n"));
		validationMessagesSummary.clear();

		return stringBuilder.toString();
	}

}
