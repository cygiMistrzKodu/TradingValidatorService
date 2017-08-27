package com.test.trading.tradingValidatorService.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.test.trading.tradingValidatorService.services.TradingDataValidatorService;

@RestController
public class TradingDataController {

	@Autowired
	TradingDataValidatorService tradingDataValidatorService;

	@RequestMapping(value = "/checkTransactions", method = RequestMethod.POST)
	public String checkTransactions(@RequestBody String transactions) {

		return tradingDataValidatorService.checkTransactions(transactions);

	}

}
