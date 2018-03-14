/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.furb.Controladores;

import br.com.furb.Modelos.AnalisaDados;
import java.util.ArrayList;

/**
 *
 * @author Alexandre
 */
public class AnaliseControlador {
    
    protected AnalisaDados model;
    
    public AnaliseControlador()
    {
        model = new AnalisaDados();
    }
    
    public String equipeAction() {
        return model.getDevText();
    }
    
    public ArrayList analisaAction(String param)
    {
        ArrayList retorno = model.getAnaliseResult(param);
        return retorno;
    }
}
