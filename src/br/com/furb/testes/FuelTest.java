package br.com.furb.testes;
import static org.junit.Assert.*;

import org.junit.Test;

import br.com.furb.exceptions.InvalidFuelException;
import br.com.furb.exceptions.InvalidSymbolException;
import br.com.furb.model.ExpressionValidator;

public class FuelTest {

	@Test
	public void testValidFuel1() {
		ExpressionValidator ex = new ExpressionValidator();
		ex.process("Álcool Biocombustível Diesel Gasolina");
		int qty = ex.getQtyFuel();
		assertEquals(4, qty);
	}
	
	@Test(expected = InvalidFuelException.class) 
	public void testInvalidValue1() {
		ExpressionValidator ex = new ExpressionValidator();
		ex.process("Álcoole");
	}
	
	@Test(expected = InvalidSymbolException.class) 
	public void testInvalidValue2() {
		ExpressionValidator ex = new ExpressionValidator();
		ex.process("diesel");
	}
	
	@Test(expected = InvalidSymbolException.class) 
	public void testInvalidValue3() {
		ExpressionValidator ex = new ExpressionValidator();
		ex.process("gasolina");
	}	
	
	@Test(expected = InvalidSymbolException.class) 
	public void testInvalidValue4() {
		ExpressionValidator ex = new ExpressionValidator();
		ex.process("Alcool");
	}	

}
