package br.com.furb.testes;

import static org.junit.Assert.*;

import org.junit.Test;

import br.com.furb.exceptions.InvalidDigitException;
import br.com.furb.model.ExpressionValidator;

public class KMTest {

	@Test
	public void testValidKM1() {
		ExpressionValidator ex = new ExpressionValidator();
		ex.process("200 330 0 1 4.400 44.000 200.000 199.999");
		int qty = ex.getQtyKM();
		assertEquals(8, qty);
	}
	
	@Test(expected = InvalidDigitException.class) 
	public void testInvalidKM1() {
		ExpressionValidator ex = new ExpressionValidator();
		ex.process("200.001");
	}
	
	@Test
	public void testInvalidKM3() {
		ExpressionValidator ex = new ExpressionValidator();
		// não sera um illegal argument exception pois será incluido no grupo de Ano
		ex.process("1500");
		int qty = ex.getQtyKM();
		assertEquals(0, qty);
	}	
	
	@Test(expected = InvalidDigitException.class) 
	public void testInvalidKM4() {
		ExpressionValidator ex = new ExpressionValidator();
		ex.process("44000");
	}
	
	@Test(expected = InvalidDigitException.class) 
	public void testInvalidKM5() {
		ExpressionValidator ex = new ExpressionValidator();
		ex.process("0044000");
	}	

}
