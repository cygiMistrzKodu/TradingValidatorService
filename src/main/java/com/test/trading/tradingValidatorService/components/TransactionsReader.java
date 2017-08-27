package com.test.trading.tradingValidatorService.components;

import com.test.trading.tradingValidatorService.helpers.TransactionFileds;

public interface TransactionsReader {

	String getTransactions();

	void setTransactions(String transactions);

	String getFieldValue(int transactionNumber, TransactionFileds transactionFileds);

	int getTransactionCount();

	String getTransaction(int transactionNumber);

}
