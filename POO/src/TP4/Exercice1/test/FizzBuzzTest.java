package TP4.Exercice1.test;

import TP4.Exercice1.core.FizzBuzz;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class FizzBuzzTest {

    private int input;
    private String expectedResult;

    public FizzBuzzTest(int input, String expectedResult) {
        this.input=input;
        this.expectedResult=expectedResult;
    }

    @Parameterized.Parameters
    public static Collection values() {
        return Arrays.asList(new Object[][]{
                {1, "1"},
                {2, "2"},
                {3, "Fizz"},
                {4, "4"},
                {5, "Buzz"},
                {6, "Fizz"},
                {9, "Fizz"},
                {15, "FizzBuzz"},
                {20, "Buzz"},
                {25, "Buzz"}
        });
    }

    @Test
    public final void testFizzBuzz() {
        String res = FizzBuzz.fizzbuzz(input);
        Assert.assertEquals("La méthode ne renvoie pas le bon résultat avec " +input, expectedResult, res);
    }
}
