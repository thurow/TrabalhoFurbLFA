package br.com.furb.testes;

import static org.junit.Assert.*;

import org.junit.Test;

import br.com.furb.exceptions.InvalidDigitException;
import br.com.furb.model.ExpressionValidator;

public class YearTest {

	@Test
	public void testValidYear1() {
		ExpressionValidator ex = new ExpressionValidator();
		ex.process("2014 2015 1032 1453 4320 2189 2018");
		int qty = ex.getQtyYear();
		assertEquals(7, qty);
	}
	
	@Test
	public void testInvalidYear1() {
		ExpressionValidator ex = new ExpressionValidator();
		ex.process("2.001");
		// n�o sera um illegal argument exception pois ser� incluido no grupo de KM
		int qty = ex.getQtyYear();
		assertEquals(0, qty);		
	}
	
	@Test
	public void testInvalidYear3() {
		ExpressionValidator ex = new ExpressionValidator();	
		ex.process("213");
		// n�o sera um illegal argument exception pois ser� incluido no grupo de KM
		int qty = ex.getQtyYear();
		assertEquals(0, qty);			

	}	
	
	@Test(expected = InvalidDigitException.class) 
	public void testInvalidYear4() {
		ExpressionValidator ex = new ExpressionValidator();
		ex.process("20014");
	}
	
	@Test(expected = InvalidDigitException.class) 
	public void testInvalidYear5() {
		ExpressionValidator ex = new ExpressionValidator();
		ex.process("0153");
	}	
	
	

}
