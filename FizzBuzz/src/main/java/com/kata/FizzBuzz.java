package com.kata;

public class FizzBuzz {

    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 100;

public String getFizzBuzz (int number){
    if (number % 15 == 0) return "FizzBuzz";
    if (number % 3 == 0) return "Fizz";
    if (number % 5 == 0) return "Buzz";

    return String.valueOf(number);
};

public static void main(String[] args) {
       FizzBuzz fizzBuzz = new FizzBuzz();
       for (int i = MIN_NUMBER; i <= MAX_NUMBER; i++){
           System.out.println(fizzBuzz.getFizzBuzz(i));
        }
    }
}
