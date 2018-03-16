/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.furb.model;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.furb.exceptions.InvalidDigitException;
import br.com.furb.exceptions.InvalidFuelException;
import br.com.furb.exceptions.InvalidSymbolException;
import br.com.furb.exceptions.InvalidValueException;

/**
 *
 * @author gseibt
 */
public class ExpressionValidator {

	@Override
	public String toString() {
		return "ExpressionValidator [qtyEngine=" + qtyEngine + ", qtyFuel=" + qtyFuel + ", qtyValue=" + qtyValue
				+ ", qtyKM=" + qtyKM + ", qtyYear=" + qtyYear + "]";
	}

	// private String word;
	private static final String kmRegex = "^([0-9]{1,3}\\.[0-9]{3}|[0-9]{1,3})$"; // [0-9]{2,3}\.[0-9]{3}|[0-9]{1}\.[0-9]{3}|[0-9]{1,3}
	private static final String yearRegex = "^\\d{4}$";
	private static final String engineRegex = "^([1-9]['.'][0-9])$";
	private static final String checkZero_Digit = "^[0]";
	private static final String fuelRegex = "^(�lcool|Biocombust�vel|Diesel|Gasolina)$";
	private static final String symbolRegex = "^([�]|[B]|[D]|[G]|[R])";
	private static final String valueRegex = "^(R\\$[0-9]{1,3}\\.[0-9]{3}\\,[0-9]{2}|R\\$[0-9]{1,3}\\,[0-9]{2})";/// "(R\\$[0-9]{1,3}\\.[0-9]{3}\\,[0-9]{2})";
	private static final String invalidValueRegex = "(R\\$[0]{2,}|R\\$[0]\\,[0]{2,}|R\\$[0]{1,}[1-9])";
	private static final String isFuelRegex = "^([�]|[B]|[D]|[G])";
	private static final String isValueRegex = "^R\\$";

	private int qtyEngine;
	private int qtyFuel;
	private int qtyValue;
	private int qtyKM;
	private int qtyYear;
	private InvalidEnum invalidEnum;

	private Matcher matcher;

	public int getQtyEngine() {
		return qtyEngine;
	}

	public int getQtyFuel() {
		return qtyFuel;
	}

	public int getQtyValue() {
		return qtyValue;
	}

	public int getQtyKM() {
		return qtyKM;
	}

	public int getQtyYear() {
		return qtyYear;
	}

	public String process(String strTextArea) {
		int currentLine = 1;
		for (String line : strTextArea.split("\r\n")) {
			for (String word : line.split("\\s+")) {
				if (Character.isDigit(word.charAt(0))) {
					if (!validateNumber(word)) {
						throw new InvalidDigitException("erro na linha - " + currentLine + " motor, ano ou KM inv�lido " + word);
					} 
				} else {
					if (!validateSymbol(word)) {
						switch (invalidEnum) {
						case INVALID_VALUE:
							throw new InvalidValueException("erro na linha - " + currentLine + " valor inv�lido: " + word);
						case INVALID_FUEL:
							throw new InvalidFuelException("erro na linha - " + currentLine + " combust�vel inv�lido: " + word);
						case INVALID_SYMBOL:
							throw new InvalidSymbolException("erro na linha - " + currentLine + " s�mbolo(s) inv�lido(s): " + word);
						}
					}
				}

				currentLine++;
			}
		}

	return this.toString();

	}

	public boolean validateNumber(String word) {
		
		matcher = Pattern.compile(checkZero_Digit).matcher(word);
		if (matcher.find()) {
			this.setInvalidEnum(InvalidEnum.INVALID_DIGIT);
			return false;
		}
		
		matcher = Pattern.compile(yearRegex).matcher(word);
		if (matcher.find()) {
			qtyYear++;
			return true;
		}
		matcher = Pattern.compile(engineRegex).matcher(word);
		if (matcher.find()) {
			qtyEngine++;
			return true;
		}
		matcher = Pattern.compile(kmRegex).matcher(word);
		if (matcher.find()) {
			if (Integer.parseInt(word.replaceAll("\\.", "")) <= 200000) {
				qtyKM++;
				return true;
			}
		}
		
		this.setInvalidEnum(InvalidEnum.INVALID_DIGIT);
		return false;
	}

	public boolean validateSymbol(String word) {

		matcher = Pattern.compile(symbolRegex).matcher(word);
		if (!matcher.find()) {
			this.setInvalidEnum(InvalidEnum.INVALID_SYMBOL);
			return false;
		}
		
		matcher = Pattern.compile(isFuelRegex).matcher(word);
		if(matcher.find()) {
			matcher = Pattern.compile(fuelRegex).matcher(word);
			if (matcher.find()) {
				qtyFuel++;
				return true;
			}
			
			this.setInvalidEnum(InvalidEnum.INVALID_FUEL);
			return false;
		}

		matcher = Pattern.compile(isValueRegex).matcher(word);
		if (matcher.find()) {
			matcher = Pattern.compile(invalidValueRegex).matcher(word);
			if (matcher.find()) {
				this.setInvalidEnum(InvalidEnum.INVALID_VALUE);
				return false;
			}
			
			matcher = Pattern.compile(valueRegex).matcher(word);
			if (matcher.find()) {
				qtyValue++;
				return true;
			}
			
			this.setInvalidEnum(InvalidEnum.INVALID_VALUE);
			return false;			
		}
		
		this.setInvalidEnum(InvalidEnum.INVALID_SYMBOL);
		return false;
	}

	public InvalidEnum getInvalidEnum() {
		return invalidEnum;
	}

	public void setInvalidEnum(InvalidEnum invalidEnum) {
		this.invalidEnum = invalidEnum;
	}

}
