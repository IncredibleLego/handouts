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

package it.unimi.di.prog2.e06;

import java.util.Scanner;

/** Esercizio 4.3 di PDJ.
 * 
 * @author Corrado Francesco Emanuele
 */
public class SumClient {

  /**
   * Sums all the elements of an array of integers
   * 
   * @param arr
   * @return the sum of all elements in arr
   * @throws NullPointerException if arr is null
   */
  public static int sumElements(int[] arr) throws NullPointerException {
    //REQUIRES: arr is not null, else throws NullPointerException
    //EFFECTS: returns the sum of all elements in arr, else throws NullPointerException
    if (arr == null) {
      throw new NullPointerException("Array is null");
    }
    int sum = 0;
    for (int i = 0; i < arr.length; i++) {
      sum += arr[i];
    }
    return sum;
  }

  /**
   * Reads a sequence of max 100 integers, and prints the sum in System.out
   * 
   * @param args
   */
  public static void main(String[] args) {
    //REQUIRES: args containing integers separated by space, not more than 100
    //EFFECTS: sums all of the elements of args and prints the result
    int[] arr = new int[100];
    int c = 0;
    try (Scanner s = new Scanner(System.in)){
      while (s.hasNext()){
        String[] values = s.nextLine().split(" ");
        for (int i=0; i < values.length; i++){
          arr[c] = Integer.parseInt(values[i]);
          c++;
          if (c == 100){
            break;
          }
        }
      }
    }
    System.out.println(sumElements(arr));
  }

  /** . */
  private SumClient() {}

  // Il main di questa classe legge dal flusso di ingresso una sequenza di al
  // più 100 interi e ne emette la somma nel flusso d'uscita.

}

/* 4.3 A specification for a procedure that computes the sum of the elements in an array of integers might require a nonempty array, return 0 if the array is empty, 
or throw an exception if the array is empty. Discuss which alternative is best and provide the specification for the procedure. */