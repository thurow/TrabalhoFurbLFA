/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.furb.Modelos;

import java.util.ArrayList;

/**
 *
 * @author Alexandre
 */
public class AnalisaDados {
    protected ExpressionValidator validator;
    
    public AnalisaDados()
    {
        validator = new ExpressionValidator();
    }

    public String getDevText()
    {
        return "Equipe de desenvolvedores: Alexandre Thurow, Gabriel Todesco e Gustavo Merini.";
    }

    public String getAnaliseResult(String param) {
        return validator.process(param);
    }
}
