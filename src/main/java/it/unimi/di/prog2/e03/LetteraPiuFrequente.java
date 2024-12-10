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

package it.unimi.di.prog2.e03;

import java.util.Scanner;
/**
 * Vedi <a
 * href="https://github.com/mapio/labprog/blob/master/esercizi/lettera_piu_frequente/Testo.md">testo</a>,
 * 
 * @author Corrado Francesco Emanuele
 */
public class LetteraPiuFrequente {

 /**
   * Determines the most frequent letter in rows of strings
   * 
   * <p>Take rows of strings, and counts each letter. System.out prints the most common letter between all strings
   * 
   * @param args
   */
  public static void main(String[] args) {
    // REQUIRES: System.in contains some lines of strings
    // MODIFIES: System.in and System.out
    // EFFECTS:  Read some line of text from System.in, each line containing strings,
    // saves in System.out the most common letter and prints it
      try (Scanner s = new Scanner(System.in)) {
        String total = "";
        while (s.hasNext()) {
          final String parola = s.nextLine().replace(" ", "");
          total = total + parola;
        }
        int maxOccorrenza = 0;
        for (int i = 0; i < total.length(); i++) {
          char c = total.charAt(i);
          String accorciata = total.replace(String.valueOf(c), "");
          int l = total.length() - accorciata.length();
          if (l > maxOccorrenza) {
            maxOccorrenza = l;
          }
        }
        System.out.println(maxOccorrenza);
      }
    }
    /** . */
    private LetteraPiuFrequente() {}
  }