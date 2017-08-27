package com.test.trading.tradingValidatorService.components.impl;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.test.trading.tradingValidatorService.components.NonWorkingDayChecker;

@Component
public class NonWorkindDayCheckerImpl implements NonWorkingDayChecker {

	private static Set<DayOfWeek> freeDays = new HashSet<>();

	static {

		freeDays.add(DayOfWeek.SATURDAY);
		freeDays.add(DayOfWeek.SUNDAY);

	}

	@Override
	public Boolean check(LocalDate date) {

		return freeDays.contains(date.getDayOfWeek());
	}

}
