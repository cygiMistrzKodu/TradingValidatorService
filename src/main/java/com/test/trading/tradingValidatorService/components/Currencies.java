package com.test.trading.tradingValidatorService.components;

import java.io.File;

public interface Currencies {
	
	Boolean checkCurrencyCode(String code);
	
	void readCurrencyCodeFromFile(File file);

}
