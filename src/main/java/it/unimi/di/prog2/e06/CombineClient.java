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

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/** Esercizio 4.4 di PDJ.
 * 
 * @author Corrado Francesco Emanuele
 */
public class CombineClient {

  /**
   * Multiplies each element of a by the sum of the elements of b
   * 
   * @param a
   * @param b
   * @throws NullPointerException if a or b is null
   */
  static void combine (int[ ] a, int[ ] b) throws NullPointerException {
    //REQUIRES: a and b are not null, else throws NullPointerException
    //MODIFIES: a
    //EFFECTS: multiplies each element of a by the sum of the elements of b
    if (a == null || b == null) {
      throw new NullPointerException("Array is null");
    }
    int sum = 0;
    for (int i = 0; i < b.length; i++) {
      sum += b[i];
    }
    for (int i = 0; i < a.length; i++) {
      a[i] *= sum;
    }
  }

  /**
   * Decodifica una stringa contenente interi separati da spazi.
   *
   * @param string la stringa in ingresso, non può essere {@code null} e deve contenere interi
   *     separati da spazi.
   * @return gli interi contenuti nella stringa.
   */
  private static int[] parseInts(String string) {
    List<Integer> list = new ArrayList<>();
    try (Scanner sl = new Scanner(string)) {
      while (sl.hasNextInt()) list.add(sl.nextInt());
    }
    int[] result = new int[list.size()];
    for (int i = 0; i < list.size(); i++) result[i] = list.get(i);
    return result;
  }

  /**
   * Reads lines from standard input, decodes them and prints the result.
   * 
   * @param args string of numbers separated by spaces
   */
  public static void main(String[] args) {
      //REQUIRES: args containing integers separated by space
      //EFFECTS: reads two lines from standard input, decodes them and prints the result
      try (Scanner s = new Scanner(System.in)){
        while (s.hasNext()){
          String str = s.nextLine();
          int[] a = parseInts(str);
          int[] b = parseInts(s.nextLine());
          combine(a, b);
          for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
          }
        }
      }
  }

  /** . */
  private CombineClient() {}

  // Il main di questa classe legge due righe dal flusso di ingresso ciascuna
  // delle quali contiene gli interi (separati da spazi) di uno dei due array da
  // combinare e ne emette il risultato della combinazione (separando gli interi
  // uno per linea). Può avvalersi della funzione precedente per decodificare
  // ciascuna delle due linee in ingresso.

}

/*Consider a procedure
  static void combine (int[ ] a, int[ ] b)
that multiplies each element of a by the sum of the elements of b; for example, if a = [1, 2, 3] and b = [4, 5], then on return a = [9, 18, 27].
What should this procedure do if a or b is null or empty? Give a specification for combine that answers these questions and explain why your specification 
is a good one. */
