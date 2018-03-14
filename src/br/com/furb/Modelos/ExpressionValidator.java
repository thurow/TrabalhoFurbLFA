/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.furb.model;

import java.util.ArrayList;
import java.util.Arrays;

import br.com.furb.model.EnumType;

/**
 *
 * @author gseibt
 */
public class ExpressionValidator {
    
    private String word;
    private EnumType type;
    private int qtyEngine;
    private int qtyFuel;
    private int qtyValue;
    private int qtyKM;

    /**
     * @return the word
     */
    public String getword() {
        return word;
    }

    /**
     * @param word the word to set
     */
    public void setword(String word) {
        this.word = word;
    }
   
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
    			validateNumber(word);
    			validateSymbol(word);
			}
    		currentLine++;
		}
    }
    
    private boolean validateNumber(String word) {
    /*
     * qualquer palavra que inicia com digito e não segue o padrão de formação especificado para Montor, Ano ou KM é inválido    
     */
        return true;
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
