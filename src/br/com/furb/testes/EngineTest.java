package br.com.furb.testes;

import static org.junit.Assert.*;

import org.junit.Test;

import br.com.furb.exceptions.InvalidDigitException;
import br.com.furb.model.ExpressionValidator;

public class EngineTest {

	@Test
	public void testValidEngine1() {
		ExpressionValidator ex = new ExpressionValidator();
		ex.process("1.2 1.3 1.4 2.0 2.5 2.6 3.4 5.4");
		int qty = ex.getQtyEngine();
		assertEquals(8, qty);
	}
	
	@Test
	public void testInvalidEngine2() {
		ExpressionValidator ex = new ExpressionValidator();
		ex.process("1");
		// não sera um illegal argument exception pois será incluido no grupo de KM
		int qty = ex.getQtyEngine();
		assertEquals(0, qty);			
	}
	
	@Test(expected = InvalidDigitException.class) 
	public void testInvalidEngine3() {
		ExpressionValidator ex = new ExpressionValidator();	
		ex.process("1.");
		// não sera um illegal argument exception pois será incluido no grupo de KM
		int qty = ex.getQtyEngine();
		assertEquals(0, qty);			

	}	
	
	@Test(expected = InvalidDigitException.class) 
	public void testInvalidEngine4() {
		ExpressionValidator ex = new ExpressionValidator();
		ex.process("2.34");
	}
	
	@Test(expected = InvalidDigitException.class) 
	public void testInvalidEngine5() {
		ExpressionValidator ex = new ExpressionValidator();
		ex.process("01.3");
	}	

}
