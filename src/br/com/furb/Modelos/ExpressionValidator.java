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
	private static final String kmRegex = "[0-9]{1,3}\\.[0-9]{3}|[0-9]{1,3}"; // [0-9]{2,3}\.[0-9]{3}|[0-9]{1}\.[0-9]{3}|[0-9]{1,3}
	private static final String yearRegex = "\\d{4}";
	private static final String engineRegex = "[1-9]['.'][0-9]";
	private static final String fuelRegex = "Álcool|Biocombustível|Diesel|Gasolina";
	private static final String symbolRegex = "^([Á]|[B]|[D]|[G]|[R])";
	private static final String valueRegex = "(R\\$[0-9]{1,3}\\.[0-9]{3}\\,[0-9]{2}|R\\$[0-9]{1,3}\\,[0-9]{2})";/// "(R\\$[0-9]{1,3}\\.[0-9]{3}\\,[0-9]{2})";
	private static final String invalidValueRegex = "(R\\$[0]{2})";
	private int qtyEngine;
	private int qtyFuel;
	private int qtyValue;
	private int qtyKM;
	private int qtyYear;
	private Matcher matcher;

	public int getQtyEngine() {
		return qtyEngine;
	}

	public void setQtyEngine(int qtyEngine) {
		this.qtyEngine = qtyEngine;
	}

	public int getQtyFuel() {
		return qtyFuel;
	}

	public void setQtyFuel(int qtyFuel) {
		this.qtyFuel = qtyFuel;
	}

	public int getQtyValue() {
		return qtyValue;
	}

	public void setQtyValue(int qtyValue) {
		this.qtyValue = qtyValue;
	}

	public int getQtyKM() {
		return qtyKM;
	}

	public void setQtyKM(int qtyKM) {
		this.qtyKM = qtyKM;
	}

	public int getQtyYear() {
		return qtyYear;
	}

	public void setQtyYear(int qtyYear) {
		this.qtyYear = qtyYear;
	}

	public String process(String strTextArea) {
		int currentLine = 1;
		for (String line : strTextArea.split("\r\n")) {
			for (String word : line.split("\\s")) {
				if (Character.isDigit(word.charAt(0))) {
					if (!validateNumber(word)) {
						throw new IllegalArgumentException("KM, ano ou motor inválido na linha " + currentLine);
					} else {
						if (!validateSymbol(word)) {
							throw new IllegalArgumentException("Simbolo inválido na linha " + currentLine);
						}
					}

				}

				currentLine++;
			}
		}

		return this.toString();

	}

	public boolean validateNumber(String word) {
		Matcher matcher;
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

		return false;
	}

	public boolean validateSymbol(String word) {

		matcher = Pattern.compile(symbolRegex).matcher(word);
		if (!matcher.find()) {
			return false;
		}
		matcher = Pattern.compile(fuelRegex).matcher(word);
		if (matcher.find()) {
			qtyFuel++;
			return true;
		}
		matcher = Pattern.compile(valueRegex).matcher(word);
		if (matcher.find()) {
			matcher = Pattern.compile(invalidValueRegex).matcher(word);
			if (matcher.find()) {
				return false;
			}
			qtyValue++;
			return true;
		}
		return false;
	}

}
