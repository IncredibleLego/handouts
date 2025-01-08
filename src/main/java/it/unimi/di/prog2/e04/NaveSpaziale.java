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

/**
 * Vedi <a
 * href="https://github.com/mapio/labprog/blob/master/esercizi/nave_spaziale/Testo.md">testo</a>.
 * 
 * @author Corrado Francesco Emanuele
 */
public class NaveSpaziale {

  /**
   * Adds to a string a given admount of characters
   * 
   * <p>Given a string, in adds to the string the n admount of characters c
   * 
   * @param str the string to add to 
   * @param n number of characters to add
   * @param c character to add
   * @return the string with the added characters
   */
  public static String inserisci(String str, int n, char c){
    //REQUIRES: str, n, c
    //MODIFIES: str
    //EFFECTS: Adds to str the element c for n times
    for (int i=0; i < n; i++){
      str += c;
    }
    return str;
  }

  /**
   * Takes two coords and determines the mininmum steps
   * 
   * <p>Takes in input from args two numbers that are the "from" and "to" coords of a spaceship: knowing that P means "+1 to from" and S means
   * "from*4", the minimum number of steps needed to from "from" to "to" is determined
   * 
   * @param args input numbers
   */
  public static void main(String[] args){
    //REQUIRES: args[0] and args[1] cointaining int numbers
    //MODIFIES: System.out
    //EFFECTS: Prints a string containing a sequence of "P" and "S" rapresenting the
    //minimum number of steps needed to go from args[0] to args[1]
    String output="";
    int from = Integer.parseInt(args[0]);
    int to = Integer.parseInt(args[1]);
    int objective = to;
    int multiplier = 1;
    if (to < from*4){
      output = inserisci(output, from-to, 'P');
    }else{
      for (;;){
        if (objective/4 <= from*4){
          objective /= 4;
          break;
        }
        objective /= 4;
        multiplier++;
      }
      if (objective < from*4){
        output = inserisci(output, objective-from, 'P');
      }else{
        output = inserisci(output, 1, 'S');
      }
      output = inserisci(output, multiplier, 'S');
      int check = (int) (to - (objective* Math.pow(4, multiplier)));
      if (check != 0){
        output = inserisci(output, check, 'P');
      }

    }
    System.out.println(output);
  }

  /** . */
  private NaveSpaziale() {}

  // Se String[] args è il vettore che contiene gli argomenti sulla linea
  // di comando, potete convertire i primi due in numeri interi con le
  // dichiarazioni (e inizializzazioni) seguenti
  //
  // int from = Integer.parseInt(args[0]);
  // int to = Integer.parseInt(args[1]);
  //
  // non c'è bisogno di importare alcun package per poter usare Integer.
}
