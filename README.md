# Fraction

Write a program that implements the addition of fractions. Fractions must be reduced. An implementation of the greatest common divisor (GCD) is provided:

```text
function gcd(a, b) {
  return b === 0 ? a : gcd(b, a % b);
}
```
