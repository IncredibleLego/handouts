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
 * href="https://github.com/mapio/labprog/blob/master/esercizi/bounding_box/Testo.md">testo</a>,
 * 
 * @author Corrado Francesco Emanuele
 */
public class BoundingBox {

  /**
   * Determines the minimum dimension of a bounding box
   * 
   * <p>Take rows of chars "." cointaining a figure formed by "*" and determines the minimum
   * dimension of the bounding box that contains the figure
   * 
   * @param args ignored
   */
    public static void main(String[] args) {
    // REQUIRES: System.in contains some line, formed by "." and "*"
    // MODIFIES: System.in and System.out
    // EFFECTS:  Read some line of text from System.in, each line containing "." and "*",
    // calculates the dimension of the bounding box and writes in System.out the result
      try (Scanner s = new Scanner(System.in)) {
        int maxX = 0, minX = 0, maxY = 0, minY = 0, count = 1;
        while (s.hasNext()) {
          final String linea = s.nextLine();
          char[] array = linea.toCharArray();
          for (int i = 0; i < linea.length(); i++) {
            if (array[i] == '*') {
              if (minX == 0) {
                maxX = i + 1;
                minX = i + 1;
                maxY = count;
                minY = count;
              }
              if (i + 1 < minX) {
                minX = i + 1;
              }
              if (i + 1 > maxX) {
                maxX = i + 1;
              }
              if (count > maxY) {
                maxY = count;
              }
            }
          }
          count++;
        }
        int X = maxX - minX + 1;
        int Y = maxY - minY + 1;
        System.out.print(Y + " " + X);
      }
  }

  /** . */
  private BoundingBox() {}
}