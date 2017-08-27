package com.test.trading.tradingValidatorService.components.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.test.trading.tradingValidatorService.components.SupportedSyles;

@Component
public class SupportedSylesImpl implements SupportedSyles {

	private static Set<String> styles = new HashSet<>();

	static {
		styles.add("EUROPEAN");
		styles.add("AMERICAN");
	}

	@Override
	public Boolean check(String style) {
		return styles.contains(style);
	}

}
