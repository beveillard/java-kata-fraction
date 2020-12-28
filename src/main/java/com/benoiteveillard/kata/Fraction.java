/*
 * Write a program that implements the addition of fractions. A Fraction is a value object,
 * once created it cannot be mutated. The `add` method must return a new Fraction instance.
 * Fractions must be reduced.
 *
 * An implementation of the greatest common divisor (GCD) is provided:
 * static int gcd(int a, int b) {
 *   return b == 0 ? a : gcd(b, a % b);
 * }
 */

package com.benoiteveillard.kata;

public class Fraction {

    final private int numerator;
    final private int denominator;

    public Fraction(int numerator, int denominator) {
        int gcd = gcd(numerator, denominator);
        this.numerator = numerator / gcd;
        this.denominator = denominator / gcd;
    }

    public static Fraction add(Fraction fraction1, Fraction fraction2) {
        int numerator = fraction1.numerator * fraction2.denominator + fraction2.numerator * fraction1.denominator;
        int denominator = fraction1.denominator * fraction2.denominator;
        return new Fraction(numerator, denominator);
    }

    public static boolean isEqual(Fraction fraction1, Fraction fraction2) {
        return (fraction1.numerator == fraction2.numerator) && (fraction1.denominator == fraction2.denominator);
    }

    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
