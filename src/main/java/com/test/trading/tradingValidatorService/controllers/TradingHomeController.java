package com.test.trading.tradingValidatorService.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TradingHomeController {
	
	@RequestMapping(value = "/")
	public String homeInfo() {

		return "Transaction validation server is running";

	}

}
