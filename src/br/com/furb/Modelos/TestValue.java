package br.com.furb.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestValue {

	@Test
	public void testValidValue1() {
		ExpressionValidator ex = new ExpressionValidator();
		ex.process("R$4.500,00 R$34.003,43 R$0,93 R$4,23 R$43,23 R$432,23");
		int qty = ex.getQtyValue();
		assertEquals(6, qty);
	}

	@Test(expected = IllegalArgumentException.class) 
	public void testInvalidValue1() {
		ExpressionValidator ex = new ExpressionValidator();
		ex.process("R$00,00");
	}
	
	@Test(expected = IllegalArgumentException.class) 
	public void testInvalidValue2() {
		ExpressionValidator ex = new ExpressionValidator();
		boolean result = ex.validateSymbol("R$0,00");
		assertEquals(false, result);
	}
	
	@Test(expected = IllegalArgumentException.class) 
	public void testInvalidValue3() {
		ExpressionValidator ex = new ExpressionValidator();
		boolean result = ex.validateSymbol("R$1.000.000,00");
		assertEquals(false, result);
	}	
	
	@Test(expected = IllegalArgumentException.class) 
	public void testInvalidValue4() {
		ExpressionValidator ex = new ExpressionValidator();
		boolean result = ex.validateSymbol("R$");
		assertEquals(false, result);
	}	
	
	@Test(expected = IllegalArgumentException.class) 
	public void testInvalidValue5() {
		ExpressionValidator ex = new ExpressionValidator();
		boolean result = ex.validateSymbol("R$1,");
		assertEquals(false, result);
	}		
		
	@Test
	public void testValidFuel5() {
		
	}
	
	@Test
	public void testValidFuel6() {
		
	}
}
