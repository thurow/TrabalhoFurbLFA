
import static org.junit.Assert.*;

import org.junit.Test;

import br.com.furb.Modelos.ExpressionValidator;

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
        ex.process("1.2               2018 R$47.500,00 0              Biocombustível R$125.900,00 6.990 Diesel 1.4 R$23.800,00 Gasolina Álcool");
        int qtyFuel = ex.getQtyFuel();
        int qtyYear = ex.getQtyYear();
        int qtyEngine = ex.getQtyEngine();
        int qtyValue = ex.getQtyValue();
        int qtyKM = ex.getQtyKM();
        assertEquals(4, qtyFuel);
        assertEquals(1, qtyYear);
        assertEquals(2, qtyEngine);
        assertEquals(3, qtyValue);
        assertEquals(2, qtyKM);
    }

    @Test
    public void testValidGeneral3() {
        ExpressionValidator ex = new ExpressionValidator();
        ex.process("1.0 2018 R$47.500,00 0 Biocombustível R$125.900,00 6.990 Diesel 1.4 R$23.800,00 Gasolina Álcool");
        int qtyFuel = ex.getQtyFuel();
        int qtyYear = ex.getQtyYear();
        int qtyEngine = ex.getQtyEngine();
        int qtyValue = ex.getQtyValue();
        int qtyKM = ex.getQtyKM();
        assertEquals(4, qtyFuel);
        assertEquals(1, qtyYear);
        assertEquals(2, qtyEngine);
        assertEquals(3, qtyValue);
        assertEquals(2, qtyKM);
    }
}
