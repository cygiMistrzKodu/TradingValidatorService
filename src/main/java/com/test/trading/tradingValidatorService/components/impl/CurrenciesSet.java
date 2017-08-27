package com.test.trading.tradingValidatorService.components.impl;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.test.trading.tradingValidatorService.components.Currencies;

public class CurrenciesSet implements Currencies {

	private Set<String> currenciesCode = new HashSet<>();
	
	private final static String CURRENCY_ENTRY = "CcyNtry";
	private final static String CURRENCY_CODE = "Ccy";

	@Override
	public Boolean checkCurrencyCode(String code) {
		return currenciesCode.contains(code);
	}

	@Override
	public void readCurrencyCodeFromFile(File file) {

		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			Document document = documentBuilder.parse(file);
			document.getDocumentElement().normalize();

			NodeList currencyEntrylist = document.getElementsByTagName(CURRENCY_ENTRY);

			for (int index = 0; index < currencyEntrylist.getLength(); index++) {

				Node node = currencyEntrylist.item(index);

				if (node.getNodeType() == Node.ELEMENT_NODE) {

					Element element = (Element) node;

					if (element.getElementsByTagName(CURRENCY_CODE).item(0) != null) {

						String currencyCode = element.getElementsByTagName(CURRENCY_CODE).item(0).getTextContent();

						currenciesCode.add(currencyCode);

					}

				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
