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

package it.unimi.di.prog2.e04;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Vedi <a
 * href="https://github.com/mapio/labprog/blob/master/esercizi/saltapicchio/Testo.md">testo</a>, ma
 * senza il vincolo sul valore massimo per `N`.
 * 
 * @author Corrado Francesco Emanuele
 */
public class Saltapicchio {

  /**
   * Prints "saltapicchio" if the numeric series respects the conditions
   * 
   * <p>Given a value N, if all numbers given in input subtracted between them give all numbers
   * from 1 and N-1, it prints "saltapicchio"
   * 
   * @param args input number
   */
  public static void main(String []args){
    //REQUIRES: System.in
    //MODIFIES: System.in System.out
    //EFFECTS: Prints "saltapicchio" if all numbers given in args[] if deducted between themeselves give all values
    //from 1 to N-1
    int N = Integer.parseInt(args[0]);
    try (Scanner s = new Scanner(System.in)){
      while (s.hasNext()){
        boolean check = true;
        int[] risultati = new int[N-1];
        int[] array = new int[N];
        String linea = s.nextLine();
        String[] valori = linea.split(" ");
        for (int i=0; i < N; i++){
          array[i] = Integer.parseInt(valori[i]);
        }
        for (int i=0; i < N-1; i++){
          risultati[i] = Math.abs(array[i] - array[i+1]);
        }
        Arrays.sort(risultati);
        for (int i=0; i < N-1; i++){
          if (i==0){
            if (risultati[i] != 1){
              check = false;
              break;
            }
          }else{
            if (risultati[i] != risultati[i-1]+1){
              check = false;
              break;
            }
          }
        }
        if (check){
          System.out.print("saltapicchio");
        }
      }
    }
  }

  /** . */ 
  private Saltapicchio() {}
}