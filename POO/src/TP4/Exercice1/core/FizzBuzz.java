package TP4.Exercice1.core;

public class FizzBuzz {

    public static String fizzbuzz(int n) {
        String res = String.valueOf(n);

        if (n == 15) {
            res= "FizzBuzz";
        }

        else if (n%3 == 0) {
            res= "Fizz";
        }

        else if (n%5 == 0) {
            res= "Buzz";
        }

        return res;
    }
}
