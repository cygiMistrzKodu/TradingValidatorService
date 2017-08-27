package com.test.trading.tradingValidatorService.components.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.test.trading.tradingValidatorService.components.OptionProductTypes;

@Service
public class OptionProductTypesImpl implements OptionProductTypes {

	private static Set<String> optionProductTypes = new HashSet<>();

	static {
		optionProductTypes.add("VanillaOption");
	}
	
	@Override
	public Boolean check(String OptionproductName) {

		return optionProductTypes.contains(OptionproductName);
	}

}
