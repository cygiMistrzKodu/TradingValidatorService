package com.test.trading.tradingValidatorService.components.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.test.trading.tradingValidatorService.components.SupportedCustomers;

@Component
public class SupportedCustomersImpl implements SupportedCustomers {

	private static Set<String> customers = new HashSet<>();

	static {
		customers.add("JUPITER1");
		customers.add("JUPITER2");
	}

	@Override
	public Boolean check(String customer) {

		return customers.contains(customer);
	}

}
