package TP4.Exercice1.test;

import TP4.Exercice1.core.FizzBuzz;
import org.junit.Assert;
import org.junit.Test;

public class test {

    @Test
    public void testAvecValeurUn() {
        String res = FizzBuzz.fizzbuzz(1);
        Assert.assertEquals("Probleme avec le nombre 1", "1", res);
    }

    @Test
    public void testAvecValeurDeux() {
        String res = FizzBuzz.fizzbuzz(2);
        Assert.assertEquals("Probleme avec le nombre 2", "2", res);
    }

    @Test
    public void testAvecValeurTrois() {
        String res = FizzBuzz.fizzbuzz(3);
        Assert.assertEquals("Probleme avec le nombre 3", "3", res);

        res = FizzBuzz.fizzbuzz(6);
        Assert.assertEquals("Probleme avec le nombre 6", "6", res);

        res = FizzBuzz.fizzbuzz(9);
        Assert.assertEquals("Probleme avec le nombre 9", "9", res);
    }
}
