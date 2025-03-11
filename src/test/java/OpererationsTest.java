
import bussinessmodel.Operations;
import datamodels.Monom;
import datamodels.Polinom;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class OpererationsTest {

    String stringP = "x^2 + x";
    String stringQ = "x";
    Polinom polinomP = Polinom.splitPolynomial(stringP);
    Polinom polinomQ = Polinom.splitPolynomial(stringQ);
    Operations operations = new Operations(polinomP,polinomQ);
    @Test
    public void addTestAddition(){
        assertEquals(operations.add().toString(),"x^2+2.0x");
        assertNotEquals(operations.add().toString(),"4x");
    }
    @Test
    public void addTestSubtraction(){
        assertEquals(operations.subtract().toString(),"x^2");
        assertNotEquals(operations.subtract().toString(),"5x");
    }
    @Test
    public void addTestMultiplication(){
        assertEquals(operations.multiply().toString(),"x^3+x^2");
        assertNotEquals(operations.multiply().toString(),"5x");
    }
    @Test
    public void addTestDerivation(){
        assertEquals(operations.derivate(polinomP).toString(),"2.0x+1.0");
        assertNotEquals(operations.derivate(polinomP).toString(),"2x");
    }
    @Test
    public void addTestIntegration(){
        assertEquals(operations.integrate(polinomP).toString(),"0.33x^3+0.5x^2");
        assertNotEquals(operations.integrate(polinomP).toString(),"2x");
    }
    @Test
    public void addTestSplit(){
        assertEquals(polinomP.splitPolynomial(stringP).toString(),"x^2+x");
        assertNotEquals(polinomP.splitPolynomial(stringP).toString(),"x^2+321x+x");
    }
}
