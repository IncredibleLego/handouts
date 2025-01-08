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

package it.unimi.di.prog2.e05;

/** Esercizio 3.3 di PDJ.
 * 
 * @author Corrado Francesco Emanuele
 */
public class IsPrimeClient {

  /**
   * Returns true if the input is a prime number, else false
   * 
   * @param x int number
   * @return true if x is prime, else false
   */
  public static boolean isPrime(int x){
    //EFFECTS: returns true if x is prime, else returns false
    if (x <= 1){
      return false;
    }
    for (int i=2; i < x; i++){
      if (x % i == 0){
        return false;
      }
    }
    return true;
  }

  /**
   * Gets a number from args and passes it to a function. Prints result
   * 
   * @param args input number
   */
  public static void main(String[] args) { 
    //EFFECTS: creates a variable num from converting input in int and passes it to the isPrime function, printing the result in case it is positive
      int num = Integer.parseInt(args[0]);
      boolean result = isPrime(num);
      if (result){
        System.out.println(result);
      }
  }

  /** . */
  private IsPrimeClient() {}

  // Aggiunga qui un main che invochi il metodo isPrime (che può sviluppare in
  // questa o altra classe) descritto dall'esercizio 3.3 di PDJ.

  // Il main riceve un intero come parametro sulla linea di comando ed emette
  // "true" nel flusso d'uscita se e solo se esso è primo.
}