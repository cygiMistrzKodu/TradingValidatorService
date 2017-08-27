package com.test.trading.tradingValidatorService.services.impl;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.trading.tradingValidatorService.components.BasicProductTypes;
import com.test.trading.tradingValidatorService.components.Currencies;
import com.test.trading.tradingValidatorService.components.DateParser;
import com.test.trading.tradingValidatorService.components.NonWorkingDayChecker;
import com.test.trading.tradingValidatorService.components.OptionProductTypes;
import com.test.trading.tradingValidatorService.components.SpecyficStyles;
import com.test.trading.tradingValidatorService.components.SupportedCustomers;
import com.test.trading.tradingValidatorService.components.SupportedSyles;
import com.test.trading.tradingValidatorService.components.TransactionsReader;
import com.test.trading.tradingValidatorService.components.ValidationMessagesStore;
import com.test.trading.tradingValidatorService.errors.impl.BadCurrencyError;
import com.test.trading.tradingValidatorService.errors.impl.ClientNotSupportedError;
import com.test.trading.tradingValidatorService.errors.impl.DeliveryDateBeforeExpireDateError;
import com.test.trading.tradingValidatorService.errors.impl.DeliveryDateBeforePremiumDateError;
import com.test.trading.tradingValidatorService.errors.impl.ExerciseDateAfterExpireDateError;
import com.test.trading.tradingValidatorService.errors.impl.ExerciseDateBeforeTradeDateError;
import com.test.trading.tradingValidatorService.errors.impl.NonWorkindDayError;
import com.test.trading.tradingValidatorService.errors.impl.NotSupportedStyleError;
import com.test.trading.tradingValidatorService.errors.impl.ValueDateBeforeTradeDateError;
import com.test.trading.tradingValidatorService.helpers.TransactionFileds;
import com.test.trading.tradingValidatorService.services.TradingDataValidatorService;

@Service
public class TradingDataValidatorServiceImpl implements TradingDataValidatorService {

	@Autowired
	private SupportedCustomers supportedCustomers;

	@Autowired
	private BasicProductTypes basicProductType;

	@Autowired
	private OptionProductTypes optionProductTypes;

	@Autowired
	private TransactionsReader transactionsReader;

	@Autowired
	private ValidationMessagesStore validationMessagesStore;

	@Autowired
	private SpecyficStyles specyficStyles;

	@Autowired
	private SupportedSyles supportedSyles;

	@Autowired
	private DateParser dateParser;

	@Autowired
	private Currencies currencies;

	@Autowired
	private NonWorkingDayChecker nonWorkingDayChecker;

	public String checkTransactions(String transactions) {

		transactionsReader.setTransactions(transactions);

		for (int transactionNumber = 0; transactionNumber < transactionsReader
				.getTransactionCount(); transactionNumber++) {

			validationMessagesStore.setCurrentTransaction(transactionsReader.getTransaction(transactionNumber));
			validationMessagesStore.setCurrentTransactionNumber(transactionNumber);

			String customerName = transactionsReader.getFieldValue(transactionNumber, TransactionFileds.CUSTOMER);

			if (supportedCustomers.check(customerName)) {

				String productType = transactionsReader.getFieldValue(transactionNumber, TransactionFileds.TYPE);

				String tradeDateText = transactionsReader.getFieldValue(transactionNumber,
						TransactionFileds.TRADE_DATE);
				LocalDate tradeDate = dateParser.parseToDate(tradeDateText);

				if (basicProductType.check(productType)) {

					String valueDateText = transactionsReader.getFieldValue(transactionNumber,
							TransactionFileds.VALUE_DATE);

					LocalDate valueDate = dateParser.parseToDate(valueDateText);

					if (valueDate.isBefore(tradeDate)) {
						validationMessagesStore.appendError(new ValueDateBeforeTradeDateError());
					}

					if (nonWorkingDayChecker.check(valueDate)) {

						validationMessagesStore
								.appendError(new NonWorkindDayError(TransactionFileds.VALUE_DATE, valueDate));

					}

				}

				if (optionProductTypes.check(productType)) {

					String productStyle = transactionsReader.getFieldValue(transactionNumber, TransactionFileds.STYLE);

					if (supportedSyles.check(productStyle)) {

						String expireDateText = transactionsReader.getFieldValue(transactionNumber,
								TransactionFileds.EXPIRE_DATE);

						String premiumDateText = transactionsReader.getFieldValue(transactionNumber,
								TransactionFileds.PREMIUM_DATE);

						String deliveryDateText = transactionsReader.getFieldValue(transactionNumber,
								TransactionFileds.DELIVERY_DATE);

						LocalDate expireDate = dateParser.parseToDate(expireDateText);
						LocalDate premiumDate = dateParser.parseToDate(premiumDateText);
						LocalDate deliveryDate = dateParser.parseToDate(deliveryDateText);

						if (deliveryDate.isBefore(expireDate)) {
							validationMessagesStore.appendError(new DeliveryDateBeforeExpireDateError());
						}

						if (deliveryDate.isBefore(premiumDate)) {
							validationMessagesStore.appendError(new DeliveryDateBeforePremiumDateError());
						}

						if (specyficStyles.check(productStyle)) {

							String exerciseDateText = transactionsReader.getFieldValue(transactionNumber,
									TransactionFileds.EXCERCISE_DATE);

							LocalDate exerciseDate = dateParser.parseToDate(exerciseDateText);

							if (exerciseDate.isBefore(tradeDate)) {

								validationMessagesStore.appendError(new ExerciseDateBeforeTradeDateError());
							}

							if (exerciseDate.isAfter(expireDate)) {

								validationMessagesStore.appendError(new ExerciseDateAfterExpireDateError());

							}

						}

					}

					if (!supportedSyles.check(productStyle)) {

						validationMessagesStore.appendError(new NotSupportedStyleError());
					}

					String payCcy = transactionsReader.getFieldValue(transactionNumber, TransactionFileds.PAYCCY);

					if (!currencies.checkCurrencyCode(payCcy)) {

						validationMessagesStore.appendError(new BadCurrencyError(TransactionFileds.PAYCCY, payCcy));

					}

					String premiumCcy = transactionsReader.getFieldValue(transactionNumber,
							TransactionFileds.PREMIUMCCY);

					if (!currencies.checkCurrencyCode(premiumCcy)) {

						validationMessagesStore
								.appendError(new BadCurrencyError(TransactionFileds.PREMIUMCCY, premiumCcy));

					}

					String premiumType = transactionsReader.getFieldValue(transactionNumber,
							TransactionFileds.PREMIUMTYPE);

					if (!currencies.checkCurrencyCode(premiumType.substring(1))) {

						validationMessagesStore
								.appendError(new BadCurrencyError(TransactionFileds.PREMIUMTYPE, premiumType));

					}

				}

				String ccyPair = transactionsReader.getFieldValue(transactionNumber, TransactionFileds.CCYPAIR);

				if (!currencies.checkCurrencyCode(ccyPair.substring(0, 3))
						|| !currencies.checkCurrencyCode(ccyPair.substring(3))) {

					validationMessagesStore.appendError(new BadCurrencyError(TransactionFileds.CCYPAIR, ccyPair));

				}

			} else {

				validationMessagesStore.appendError(new ClientNotSupportedError(customerName));

			}

			validationMessagesStore.createMeesage();
		}

		return validationMessagesStore.getValidationSummary();
	}

}
