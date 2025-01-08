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

import java.util.Scanner;

/** Esercizio 3.1 di PDJ.
 * 
 * @author Corrado Francesco Emanuele
 */
public class GcdClient {

  /**
   * Recursive function to calculate GCD
   * 
   * <p>recursive function that by getting two numbers a and b usese the Euclidean Algorithm to calculate GCD
   * 
   * @param a first number (biggest one)
   * @param b second number (smallest one)
   * @return gcd of a and b
   */
  public static int gcd(int a, int b){
    //REQUIRES: a >= b
    //EFFECTS: by using the Euclidean Algorithm a is divided by b and the rest of the division is saved
    //in r. Then a = a, a_post = b, b = b, b_post=r and returns the gcd
    if (b==0)  {
      return a;
    }else{
      int r = a%b;
      return gcd(b, r);
    }
  }
  
  /**
   * Main gets strings of numbers and converts them
   * 
   * <p> a scanner gets strings of numbers, converts them into arrays and converts the elements into numbers to pass to the function gcd. Prints the result
   * 
   * @param args ignored
   */
  public static void main(String[] args) {
    //REQUIRES: System.in cointaining lines of strings containing numbers convertibile into ints
    //MODIFIES: System.in and System.out
    //EFFECTS: Reads a line of text from System.in, puts the values in an array and converts them into ints.
    //passes values to gcd function and prints the result in Sytem.out
    try (Scanner s = new Scanner(System.in)){
      while (s.hasNext()){
        int result;
        String numeri = s.nextLine();
        String[] num = numeri.split(" ");
        int num1 = Integer.parseInt(num[0]);
        int num2 = Integer.parseInt(num[1]);
        if (num1 > num2){
          result = gcd(num1, num2);
        }else{
          result = gcd(num2, num1);
        }
        System.out.println(result);
      }
    }
  }

  /** . */
  private GcdClient() {}

  // Aggiunga qui un main che invochi il metodo gcd (che può sviluppare in
  // questa o altra classe) descritto dall'esercizio 3.1 di PDJ.

  // Il main legge dal flusso di ingresso coppie di numeri ed emette nel flusso
  // d'uscita il loro gcd.
}