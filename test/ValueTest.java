
import static org.junit.Assert.*;

import org.junit.Test;

import br.com.furb.Modelos.ExpressionValidator;
import br.com.furb.Excessoes.InvalidValueException;

public class ValueTest {

    @Test
    public void testValidValue1() {
        ExpressionValidator ex = new ExpressionValidator();
        ex.process("R$4.500,00 R$34.003,43 R$0,93 R$4,23 R$43,23 R$432,23");
        int qty = ex.getQtyValue();
        assertEquals(6, qty);
    }

    @Test(expected = InvalidValueException.class)
    public void testInvalidValue1() {
        ExpressionValidator ex = new ExpressionValidator();
        ex.process("R$00,00");
    }

    @Test(expected = InvalidValueException.class)
    public void testInvalidValue2() {
        ExpressionValidator ex = new ExpressionValidator();
        ex.process("R$01,00");
    }

    @Test(expected = InvalidValueException.class)
    public void testInvalidValue3() {
        ExpressionValidator ex = new ExpressionValidator();
        ex.process("R$1.000.000,00");
    }

    @Test(expected = InvalidValueException.class)
    public void testInvalidValue4() {
        ExpressionValidator ex = new ExpressionValidator();
        ex.process("R$");
    }

    @Test(expected = InvalidValueException.class)
    public void testInvalidValue5() {
        ExpressionValidator ex = new ExpressionValidator();
        ex.process("R$150.000,0");
    }

    @Test(expected = InvalidValueException.class)
    public void testInvalidValue6() {
        ExpressionValidator ex = new ExpressionValidator();
        ex.process("R$150.00,00");
    }

    @Test(expected = InvalidValueException.class)
    public void testInvalidValue7() {
        ExpressionValidator ex = new ExpressionValidator();
        ex.process("R$1,");
    }

}
