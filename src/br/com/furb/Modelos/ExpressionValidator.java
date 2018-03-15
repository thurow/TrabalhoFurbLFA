/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.furb.model;

import java.util.ArrayList;
import java.util.Arrays;
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
	//private String word;
	private static final String kmRegex = "[0-9]{1,3}\\.[0-9]{3}|[0-9]{1,3}"; //[0-9]{2,3}\.[0-9]{3}|[0-9]{1}\.[0-9]{3}|[0-9]{1,3}
	private static final String yearRegex = "\\d{4}";
	private static final String engineRegex = "[1-9]['.'][0-9]";
	private static final String fuelRegex = "Álcool|Biocombustível|Diesel|Gasolina";
	private static final String symbolRegex = "^([Á]|[B]|[D]|[G]|[R])";

    private int qtyEngine;
    private int qtyFuel;
    private int qtyValue;
    private int qtyKM;
	private int qtyYear;

//    /**
//     * @return the word
//     */
//    public String getword() {
//        return word;
//    }
//
//    /**
//     * @param word the word to set
//     */
//    public void setword(String word) {
//        this.word = word;
//    }
   


    public boolean validateword(String word) {
        return true;
    }
    public String process(String strTextArea) {
    	int currentLine = 1;
    	for (String line : strTextArea.split("\r\n")) {
    		for (String word : line.split("\\s")) {
    			if(Character.isDigit(word.charAt(0))) { 
    				if (!validateNumber(word)) {
    					throw new IllegalArgumentException("KM, ano ou motor inválido na linha " + currentLine);
    				} else {
    					// identifica oq é
    					
    				}
    			} else {
    				if (!validateSymbol(word)) {
    					throw new IllegalArgumentException("Simbolo inválido na linha " + currentLine);
    				}    				
    			}
    			
			}
    		
    		currentLine++;
		}
    	
    	return this.toString();
    	
    }
    
    boolean validateNumber(String word) {
    	Matcher matcher;
    	matcher = Pattern.compile(yearRegex).matcher(word);
    	if (matcher.find()) {
    		setQtyYear(getQtyYear() + 1);
    		return true;
    	}
    	matcher = Pattern.compile(engineRegex).matcher(word);
    	if(matcher.find()) {
    		qtyEngine++;
    		return true;
    	}
    	matcher = Pattern.compile(kmRegex).matcher(word);
    	if(matcher.find()) {
    		if(Integer.parseInt(word.replaceAll("\\.", "")) <= 200000) {
    			qtyKM++;
    			return true;
    		} 
		} 
    		
		return false;
    }
    
    private boolean validateSymbol(String word) {
    	boolean result = true;
    	Matcher matcher;
    	matcher = Pattern.compile(symbolRegex).matcher(word);    	
    	if (!matcher.find()) {
    		result = false;
    	} 
    	return result;
    }
    
    private void identifyIsEngine(String word) {
        /* palavra composta por um digito 1..9, seguido de ponto, seguido de um digito
        * ex: 1.4 
        */
  
    }
    
    private void identifyIsValue(String word) {
        /*
        * EX: R$200,00
        */

    }
    
    private void identifyIsFuel(String word) {

    }
    
    private void identifyIsKM(String word) {

    }
	public int getQtyYear() {
		return qtyYear;
	}
	public void setQtyYear(int qtyYear) {
		this.qtyYear = qtyYear;
	}    

    
    
}
