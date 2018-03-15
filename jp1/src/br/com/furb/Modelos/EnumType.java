/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.furb.Modelos;

/**
 *
 * @author gseibt
 */
public enum EnumType {
    Fuel,
    Value,
    KM,
    Year("\\d{4}"),
    Engine("[1-9]['.'][1-9]");
	
	EnumType(String ) {
		
	}
    
}
