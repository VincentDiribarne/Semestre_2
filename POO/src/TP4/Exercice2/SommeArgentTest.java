package TP4.Exercice2;

import org.junit.Assert;
import org.junit.Test;

public class SommeArgentTest {
    /*private int input;
    private String expectedResult;

    public SommeArgentTest(int input, String expectedResult) {
        this.input=input;
        this.expectedResult=expectedResult;
    }*/

    @Test
    public final void testAddition() {
        SommeArgent m12CHF= new SommeArgent(12, "CHF");
        SommeArgent m14CHF= new SommeArgent(14, "CHF");
        SommeArgent m14USD= new SommeArgent(14, "USD");

        SommeArgent expected = new SommeArgent(26, "CHF");
        SommeArgent result = m12CHF.add(m14CHF);
        Assert.assertEquals(expected, result);
        //Assert.assertTrue(expected.equals(result));

        /*Assert.assertEquals(m12CHF, m12CHF);
        Assert.assertEquals(m12CHF, new SommeArgent(12, "CHF"));
        Assert.assertTrue(!m12CHF.equals(m14CHF));
        Assert.assertTrue(!m14USD.equals(m14CHF));*/

    }
}
