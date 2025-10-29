function fizzbuzz(number) {
  if (typeof number !== "number") throw new Error("parameter must be a number");

  if (number % 15 === 0) return "FizzBuzz";
  if (number % 3 === 0) return "Fizz";
  if (number % 5 === 0) return "Buzz";

  return number;
}

module.exports = { fizzbuzz };

// Permite ejecutarlo como script
if (require.main === module) {
  for (let i = 1; i <= 100; i++) {
    console.log(fizzbuzz(i));
  }
}

//npm start