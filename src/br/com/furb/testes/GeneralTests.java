package br.com.furb.testes;

import static org.junit.Assert.*;

import org.junit.Test;

import br.com.furb.model.ExpressionValidator;

public class GeneralTests {

	@Test
	public void testValidGeneral1() {
		ExpressionValidator ex = new ExpressionValidator();
		ex.process("1.2 403 2014 2.153 R$44.000,00 2015 Álcool Diesel 1.5 Biocombustível R$2,00");
		int qtyFuel = ex.getQtyFuel();
		int qtyYear = ex.getQtyYear();
		int qtyEngine = ex.getQtyEngine();
		int qtyValue = ex.getQtyValue();
		int qtyKM = ex.getQtyKM();
		assertEquals(3, qtyFuel);
		assertEquals(2, qtyYear);
		assertEquals(2, qtyEngine);
		assertEquals(2, qtyValue);
		assertEquals(2, qtyKM);
	}
	
	@Test
	public void testValidGeneral2() {
		ExpressionValidator ex = new ExpressionValidator();
		ex.process("1.2 403 2014 R$44.000,00 2015 Álcool Diesel 1.5 Biocombustível R$2,00");
		int qtyFuel = ex.getQtyFuel();
		int qtyYear = ex.getQtyYear();
		int qtyEngine = ex.getQtyEngine();
		int qtyValue = ex.getQtyValue();
		int qtyKM = ex.getQtyKM();
		assertEquals(3, qtyFuel);
		assertEquals(2, qtyYear);
		assertEquals(8, qtyEngine);
		assertEquals(8, qtyValue);
		assertEquals(1, qtyKM);
	}
	
	@Test
	public void testValidGeneral3() {
		ExpressionValidator ex = new ExpressionValidator();
		ex.process("1.2 403 2014 R$44.000,00 2015 Álcool Diesel 1.5 Biocombustível R$2,00");
		int qtyFuel = ex.getQtyFuel();
		int qtyYear = ex.getQtyYear();
		int qtyEngine = ex.getQtyEngine();
		int qtyValue = ex.getQtyValue();
		int qtyKM = ex.getQtyKM();
		assertEquals(3, qtyFuel);
		assertEquals(2, qtyYear);
		assertEquals(8, qtyEngine);
		assertEquals(8, qtyValue);
		assertEquals(1, qtyKM);
	}
	
	@Test
	public void testValidGeneral4() {
		ExpressionValidator ex = new ExpressionValidator();
		ex.process("1.2 403 2014 R$44.000,00 2015 Álcool Diesel 1.5 Biocombustível R$2,00");
		int qtyFuel = ex.getQtyFuel();
		int qtyYear = ex.getQtyYear();
		int qtyEngine = ex.getQtyEngine();
		int qtyValue = ex.getQtyValue();
		int qtyKM = ex.getQtyKM();
		assertEquals(3, qtyFuel);
		assertEquals(2, qtyYear);
		assertEquals(8, qtyEngine);
		assertEquals(8, qtyValue);
		assertEquals(1, qtyKM);
	}
}
