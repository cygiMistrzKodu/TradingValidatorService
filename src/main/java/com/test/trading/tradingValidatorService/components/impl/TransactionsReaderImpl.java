package com.test.trading.tradingValidatorService.components.impl;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.trading.tradingValidatorService.components.TransactionFiled;
import com.test.trading.tradingValidatorService.components.TransactionsReader;
import com.test.trading.tradingValidatorService.helpers.TransactionFileds;

@Component
public class TransactionsReaderImpl implements TransactionsReader {

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private TransactionFiled transactionFiled;

	private String transactions;

	private JsonNode jsonNode;

	public String getTransactions() {
		return transactions;
	}

	public void setTransactions(String transactions) {

		try {
			jsonNode = objectMapper.readTree(transactions);
		} catch (IOException e) {

			e.printStackTrace();
		}

		this.transactions = transactions;
	}

	public String getFieldValue(int transactionNumber, TransactionFileds transactionFileds) {

		return jsonNode.get(transactionNumber).get(transactionFiled.getFiledName(transactionFileds)).textValue();

	}
	
	public String getTransaction(int transactionNumber) {

		return jsonNode.get(transactionNumber).toString();

	}

	public int getTransactionCount() {
		return jsonNode.size();
	}

}
