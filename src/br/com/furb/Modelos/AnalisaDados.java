/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.furb.Modelos;

import br.com.furb.Bibliotecas.LexicalError;
import br.com.furb.Bibliotecas.Lexico;
import br.com.furb.Bibliotecas.Token;
import br.com.furb.Bibliotecas.LexicalError;
import java.util.ArrayList;

/**
 *
 * @author Alexandre
 */
public class AnalisaDados {

    protected Lexico validator;

    public AnalisaDados() {
        validator = new Lexico();
    }

    public String getDevText() {
        return "Equipe de desenvolvedores: Alexandre Thurow, Gabriel Todesco e Gustavo Merini.";
    }

    public String getAnaliseResult(String param) {
        StringBuilder result = new StringBuilder();
        result.append("dados analisados"+System.lineSeparator());
        StringBuilder error = new StringBuilder();
        String[] string;
        string = param.split("\n");
        Token t = null;
        for (int i = 0; i < string.length; i++) {

            validator.setInput(string[i]);

            try {
                t = null;
                while ((t = validator.nextToken()) != null) {
                    result.append(i+1 + "\t" + t.getLexeme() + "\t\t" + this.getType(t.getId()) + System.lineSeparator());
                }
            } catch (LexicalError e) {
                error.append("Erro na linha " + (i+1) + " - " +  e.getMessage() + ": "+ e.getToken());
                return error.toString();
            }
        }
        return result.toString();
    }

    private String getType(int i) {
        switch(i) {
            case 2 : return " Motor";
            case 3 : return " Ano";
            case 4 : return " Valor";
            case 5 : return " KM";
            case 6 : return " CHASSI";
            case 7 : return " PLACA";
            case 8 : return " MODELO MARCA COMBUSTIVEL";
            case 9 : return " ALCOOL";
            case 10: return " BICOMBUSTÍVEL";
            case 11: return " GASOLINA";
            case 12: return " DIESEL";
            default:
                return null;
        }      
    }


    
}
