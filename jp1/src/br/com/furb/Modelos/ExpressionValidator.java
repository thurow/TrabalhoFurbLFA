/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.furb.Modelos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.furb.Modelos.EnumType;

/**
 *
 * @author gseibt
 */
public class ExpressionValidator {
    
    //private String word;
	private static final String kmRegex = "^[0-9]{1,3}|[0-9]{1,3}['.'][0-9]{1,3}";
	private static final String yearRegex = "\\d{4}";
	private static final String engineRegex = "[1-9]['.'][0-9]";

    private EnumType type;
    private int qtyEngine;
    private int qtyFuel;
    private int qtyValue;
    private int qtyKM;

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
   
    /**
     * @return the type
     */
    public EnumType getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(EnumType type) {
        this.type = type;
    }    
    
    public boolean validateword(String word) {
        return true;
    }
    public void process(String strTextArea) {
    	int currentLine = 1;
    	for (String line : strTextArea.split("\r\n")) {
    		for (String word : line.split("\\s")) {
    			if(Character.isDigit(word.charAt(0))) { 
    				validateNumber(word);
    			}
    			validateSymbol(word);
			}
    		
    		currentLine++;
		}
    }
    
    boolean validateNumber(String word) {
    	boolean result = false;
    	Matcher matcher;
    	matcher = Pattern.compile(yearRegex).matcher(word);
    	if (!matcher.find()) {
    		result = false;
    	}
    	//falta os outros ainda
		return result;
    }
    
    private boolean validateSymbol(String word) {
        return true;
    }
    
    private EnumType identifyType(String word) {
        return this.getType();
    }
    
    private void identifyIsEngine(String word) {
        /* palavra composta por um digito 1..9, seguido de ponto, seguido de um digito
        * ex: 1.4 
        */
        this.setType(EnumType.Engine);
    }
    
    private void identifyIsValue(String word) {
        /*
        * EX: R$200,00
        */
        this.setType(EnumType.Value);
    }
    
    private void identifyIsFuel(String word) {
        this.setType(EnumType.Value);
    }
    
    private void identifyIsKM(String word) {
        this.setType(EnumType.KM);
    }    

    
    
}
