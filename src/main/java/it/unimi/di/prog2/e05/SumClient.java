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

/** Esercizio 3.2 di PDJ.
 * 
 * @author Corrado Francesco Emanuele
 */
public class SumClient {

  /**
   * Sums the elements of a int[] array and returns the result
   * 
   * @param a an array of int
   * @return sum of the values of a
   */

  public static int sum (int[] a){
    //EFFECTS: Returns the sum of all elements in the array
    int s=0;
    for (int i=0; i < a.length; i++){
      s += a[i];
    }
    return s;
  }

  /**
   * Returns an array with the String passed added ad int
   * 
   * <p>Returns the array a, with added elem converted in int at the end
   * 
   * @param a initial array
   * @param elem element to add
   * @return a with elem added
   */
  public static int[] add(int[] a, String elem){
    //EFFECTS: Adds the integer representation of value to the array and returns the new array
    int l = a.length;
    int newArray[] = new int[l + 1];
    System.arraycopy(a, 0, newArray, 0, l);
    newArray[l] = Integer.parseInt(elem);
    return newArray;
  }

  /**
   * Gets an array of values and converts them
   * 
   * <p> Converts an array of strings in ints, passes the ints array to a functions that sums them and prints the result
   * 
   * @param args array of strings
   */
  public static void main(String[] args) {
    //EFFECTS: converts the args array in ints and prints the elements
    int[] numbers={};
    String[] values = new String[args.length];
    System.arraycopy(args, 0, values, 0, args.length);
    for (String value : values) {
        numbers = add(numbers, value);
    }
    int result = sum(numbers);
    System.out.println(result);
  }

  /** . */
  private SumClient() {}

  // Aggiunga qui un main che invochi il metodo sum (che può sviluppare in
  // questa o altra classe) descritto dall'esercizio 3.2 di PDJ.

  // Il main riceve un elenco di interi come parametri sulla linea di comando e
  // ne emette la somma nel flusso d'ingresso.

}
