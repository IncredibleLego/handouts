/*

Copyright 2024 Massimo Santini

This file is part of "Programmazione 2 @ UniMI" teaching material.

This is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This material is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this file.  If not, see <https://www.gnu.org/licenses/>.

*/

package it.unimi.di.prog2.e10;

import java.util.Objects;

import it.unimi.di.prog2.e05.GcdClient;

/**
 * A rational number is an immutable number that can be expressed as the quotient or fraction \( p/q
 * \) of two {@code int}s, a numerator \( p \) and a non-zero denominator \( q \).
 */
public class RationalNumber {

  // EXERCISE: complete following the specification (with particular attention
  // to the eventual exceptions) and provide an implementation (including the
  // equals, hashCode, and toString methods); add methods that are adequate to
  // the specification.

  //Fields

  /**
   * The numerator of this rational number.
   */
  private final int p;
  
  /**
   * The denominator of this rational number.
   */
  private final int q;

  //Constructors

  /**
   * Creates a new rational number.
   *
   * @param numerator the numerator.
   * @param denominator the denominator.
   */
  public RationalNumber(int numerator, int denominator) {
    if (denominator == 0){
      throw new IllegalArgumentException("Denominator must be non-zero");
    }
    else if (denominator < 0) {
      numerator = -numerator;
      denominator = -denominator;
    }
    int gcd = GcdClient.gcd(numerator > 0 ? numerator : -numerator, denominator > 0 ? denominator : -denominator);
    p = numerator / gcd;
    q = denominator / gcd;
  }

  //Methods

  /**
   * Returns the sum of this rational number and another one.
   *
   * @param other the other rational number.
   * @return the sum of this rational number and {@code other}.
   */
  public RationalNumber add(RationalNumber other) {
    //REQUIRES: other is not null
    //EFFECTS: returns the sum of this rational number and other
    return new RationalNumber(p * other.q + q * other.p, q * other.q);
  }

  /**
   * Returns the product of this rational number and another one.
   *
   * @param other the other rational number.
   * @return the product of this rational number and {@code other}.
   */
  public RationalNumber mul(RationalNumber other) {
    //REQUIRES: other is not null
    //EFFECTS: returns the product of this rational number and other
    return new RationalNumber(p * other.p, q * other.q);
  }
  
  @Override
  public String toString() {
    return p + "/" + q;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null || !(obj instanceof RationalNumber obj2)) {
      return false;
    }
    return p == obj2.p && q == obj2.q;
  }

  @Override
  public int hashCode() {
    return Objects.hash(p, q);
  }
}
