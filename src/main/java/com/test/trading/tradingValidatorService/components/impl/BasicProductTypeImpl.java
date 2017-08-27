package com.test.trading.tradingValidatorService.components.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.test.trading.tradingValidatorService.components.BasicProductTypes;

@Component
public class BasicProductTypeImpl implements BasicProductTypes {

	private static Set<String> productTypes = new HashSet<>();

	static {
		productTypes.add("Spot");
		productTypes.add("Forward");
	}
	
	@Override
	public Boolean check(String productName) {
		
		return productTypes.contains(productName);
	}

}
