package com.kata;

public class FizzBuzzEfervescente {

    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 100;

    public String getFizzBuzz(int number) {
        String result = "";
        String numStr = String.valueOf(number);

        if (number % 3 == 0 || numStr.contains("3")) {
            result += "Fizz";
        }

        if (number % 5 == 0 || numStr.contains("5")) {
            result += "Buzz";
        }

        return result.isEmpty() ? numStr : result;
    }

    public static void main(String[] args) {
        FizzBuzzEfervescente fizzBuzz = new FizzBuzzEfervescente();
        for (int i = MIN_NUMBER; i <= MAX_NUMBER ; i++) {
            System.out.println(fizzBuzz.getFizzBuzz(i));
        }
    }
}
