package com.test.trading.tradingValidatorService.components.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.test.trading.tradingValidatorService.components.SpecyficStyles;

@Component
public class SpecyficStylesImpl implements SpecyficStyles {

	private static Set<String> specyficStyles = new HashSet<>();

	static {
		specyficStyles.add("AMERICAN");
	}
	
	
	@Override
	public Boolean check(String style) {
		
		return specyficStyles.contains(style);
	}

}
