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

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FractionTests {

    @Test
    @DisplayName("Test gcd of prime and 1")
    void testGCDofPrimeAnd1() {
        assertEquals(1, Fraction.gcd(7, 1));
        assertEquals(1, Fraction.gcd(1, 7));
    }

    @Test
    @DisplayName("Test gcd of prime and multiple")
    void testGCDofPrimeAndMultiple() {
        assertEquals(1, Fraction.gcd(7, 8));
        assertEquals(1, Fraction.gcd(8, 7));
    }

    @Test
    @DisplayName("Test gcd of prime and itself")
    void testGCDofPrimeAndItself() {
        assertEquals(7, Fraction.gcd(7, 7));
    }

    @Test
    @DisplayName("Test gcd of prime and multiple of itself")
    void testGCDofPrimeAndMultipleOfItself() {
        assertEquals(7, Fraction.gcd(7, 21));
        assertEquals(7, Fraction.gcd(21, 7));
    }

    @Test
    @DisplayName("Test gcd of 2 primes")
    void testGCDof2Primes() {
        assertEquals(1, Fraction.gcd(163, 197));
        assertEquals(1, Fraction.gcd(197, 163));
    }

    @Test
    @DisplayName("Test gcd of 2 non primes")
    void testGCDof2NonPrimes() {
        assertEquals(8, Fraction.gcd(32, 40));
        assertEquals(8, Fraction.gcd(40, 32));
    }

    @Test
    @DisplayName("Test isEqual returns false")
    void testIsEqualReturnsFalse() {
        Fraction fraction1 = new Fraction(3, 4);
        Fraction fraction2 = new Fraction(2, 3);
        assertFalse(Fraction.isEqual(fraction1, fraction2));
    }

    @Test
    @DisplayName("Test isEqual returns true with same fractions")
    void testIsEqualReturnsTrueWithSameFractions() {
        Fraction fraction1 = new Fraction(3, 4);
        Fraction fraction2 = new Fraction(3, 4);
        assertTrue(Fraction.isEqual(fraction1, fraction2));
    }

    @Test
    @DisplayName("Test isEqual returns true with fractions initialized differently")
    void testIsEqualReturnsTrueWithFractionsInitializedDifferently() {
        Fraction fraction1 = new Fraction(3, -4);
        Fraction fraction2 = new Fraction(-15, 20);
        assertTrue(Fraction.isEqual(fraction1, fraction2));
    }

    @Test
    @DisplayName("Test addition")
    void testAddition() {
        Fraction fraction1 = new Fraction(3, 4);
        Fraction fraction2 = new Fraction(5, -7);
        Fraction sum = new Fraction(1, 28);
        assertTrue(Fraction.isEqual(sum, Fraction.add(fraction1, fraction2)));
    }
}
