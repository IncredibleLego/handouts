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

/**
 * Vedi <a
 * href="https://github.com/mapio/labprog/blob/master/esercizi/genera_quadrato_magico/Testo.md">testo</a>,
 * 
 * @author Corrado Francesco Emanuele
 */
public class GeneraQuadratoMagico {

  /**
   * Generates a magic square from a number
   * 
   * <p>Generates a magic square of N*N given a number N from args
   * 
   * @param args the number N
   */
  public static void main(String[] args) {
  // REQUIRES: args[0] containing an int number
  // EFFECTS:  Reads a number N from args[0], prints the matrix with the result
    int x = 0;
    final int N = Integer.parseInt(args[0]);
    int[][] matrice = new int[N][N];
    int y = N / 2;
    matrice[x][y] = 1;
    x = N - 1;
    y++;
    for (int i = 2; i <= N * N; i++) {
      matrice[x][y] = i;
      x--;
      y++;
      if (x < 0 && y > N - 1) {
        x += 2;
        y--;
      }
      if (x < 0) {
        x = N - 1;
      }
      if (y > N - 1) {
        y = 0;
      }
      if (matrice[x][y] != 0) {
        x += 2;
        y--;
      }
    }
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        System.out.print(matrice[i][j] + " ");
      }
      System.out.print("\n");
    }
  }

  /** . */
  private GeneraQuadratoMagico() {}
}
