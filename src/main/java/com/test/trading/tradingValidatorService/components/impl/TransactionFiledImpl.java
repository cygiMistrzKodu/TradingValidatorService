package com.test.trading.tradingValidatorService.components.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.test.trading.tradingValidatorService.components.TransactionFiled;
import com.test.trading.tradingValidatorService.helpers.TransactionFileds;

@Component
public class TransactionFiledImpl implements TransactionFiled {
	
	private static Map<TransactionFileds, String> transactionFieldsMap = new HashMap<>();	
	
	static {
		transactionFieldsMap.put(TransactionFileds.CUSTOMER, "customer");
		transactionFieldsMap.put(TransactionFileds.TYPE, "type");
		transactionFieldsMap.put(TransactionFileds.VALUE_DATE, "valueDate");
		transactionFieldsMap.put(TransactionFileds.TRADE_DATE, "tradeDate");
		transactionFieldsMap.put(TransactionFileds.STYLE, "style");
		transactionFieldsMap.put(TransactionFileds.EXPIRE_DATE, "expiryDate");
		transactionFieldsMap.put(TransactionFileds.PREMIUM_DATE, "premiumDate");
		transactionFieldsMap.put(TransactionFileds.DELIVERY_DATE, "deliveryDate");
		transactionFieldsMap.put(TransactionFileds.EXCERCISE_DATE, "excerciseDate");
		transactionFieldsMap.put(TransactionFileds.CCYPAIR, "ccyPair");
		transactionFieldsMap.put(TransactionFileds.PAYCCY, "payCcy");
		transactionFieldsMap.put(TransactionFileds.PREMIUMCCY, "premiumCcy");
		transactionFieldsMap.put(TransactionFileds.PREMIUMTYPE, "premiumType");
		transactionFieldsMap.put(TransactionFileds.LEGAL_ENTITY, "legalEntity");
	}
	
	public  String getFiledName(TransactionFileds transactionFileds) {

		return transactionFieldsMap.get(transactionFileds);
		
	}

}
