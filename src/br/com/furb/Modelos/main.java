/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.furb.Modelos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author gseibt
 */
public class main {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner s = new Scanner(new File("C:\\Users\\dev\\Desktop\\seila.txt"));
		ArrayList<String> lineList = new ArrayList();
		ArrayList<String> wordList = new ArrayList();
		String array = "";
		while (s.hasNextLine()) {
			array += s.nextLine() + "\r\n"; 
		}
		s.close();

		ExpressionValidator ex = new ExpressionValidator();
		String xd = ex.process(array);
		System.out.println(xd);
		

	}

}
