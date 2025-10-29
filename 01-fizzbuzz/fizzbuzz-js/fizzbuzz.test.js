import { describe, it, expect } from "vitest";
import { fizzbuzz } from "./fizzbuzz.js";

describe('fizzbuzz', () => {

  it('should be a function', () => {
    expect(typeof fizzbuzz).toBe('function');
  });

  it('should throw if parameter is not a number', () => {
    expect(() => fizzbuzz()).toThrow();
    expect(() => fizzbuzz("1")).toThrow();
    expect(() => fizzbuzz(null)).toThrow();
  });

  it('should return Fizz if number is divisible by 3', () => {
    expect(fizzbuzz(3)).toBe("Fizz");
    expect(fizzbuzz(6)).toBe("Fizz");
  });

  it('should return Buzz if number is divisible by 5', () => {
    expect(fizzbuzz(5)).toBe("Buzz");
    expect(fizzbuzz(10)).toBe("Buzz");
  });

  it('should return FizzBuzz if number is divisible by 3 and 5', () => {
    expect(fizzbuzz(15)).toBe("FizzBuzz");
    expect(fizzbuzz(30)).toBe("FizzBuzz");
  });

  it('should return the number if no rule is matched', () => {
    expect(fizzbuzz(7)).toBe(7);
  });

});

//npm test