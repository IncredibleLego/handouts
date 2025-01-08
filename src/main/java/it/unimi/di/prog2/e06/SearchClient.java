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

/** Esercizio 4.2 di PDJ.
 * 
 * @author Corrado Francesco Emanuele
 */
public class SearchClient {

    /**
     * Returns the index of x in a, else -1
     * 
     * @param a int array
     * @param x int number
     * @return index of x in a, else -1
     * @throws NullPointerException if a is null
     */
    public static int searchLoop(int[] a, int x) throws NullPointerException{
        //REQUIRES: a is not null, else throws NullPointerException
        //EFFECTS: returns the index of x in a, else throws NotFoundException
        if (a == null) {
            throw new NullPointerException("Array is null");
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i] == x) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Returns the index of x in a, else -1
     * 
     * @param a int array
     * @param x int number
     * @return index of x in a, else -1
     * @throws NullPointerException if a is null
     * @throws IndexOutOfBoundsException if a[i] is out of bounds
     */
    public static int searchWhile(int[] a, int x) throws NullPointerException, IndexOutOfBoundsException{
        //REQUIRES: a is not null, else throws NullPointerException
        //EFFECTS: returns the index of x in a, else -1
        if (a == null) {
            throw new NullPointerException("Array is null");
        }
        int i = 0;
        try {
            while (true) {
                if (a[i] == x) {
                    return i;
                }
                i++;
            }
        } catch (IndexOutOfBoundsException e) {
            return -1;
        }
    }

    /**
     * Gets a number from args and passes it to a function. Prints result
     * 
     * @param args input number
     * @throws NullPointerException if args is null
     */
    public static void main(String[] args) throws NullPointerException {
      int num = Integer.parseInt(args[0]);
      try (Scanner s = new Scanner(System.in)){
      
        while (s.hasNext()){
          String[] valori = s.nextLine().split(" ");
          int[] array = new int[valori.length];
          for (int i=0; i < valori.length; i++){
            array[i] = Integer.parseInt(valori[i]);
          }
          System.out.println(searchLoop(array, num));
          //System.out.println(searchWhile(array, num));
        }
      }

    }

  /** . */
  private SearchClient() {}

  // Il main di questa classe legge dal flusso di ingresso una sequenza di
  // interi (separati da spazi) e, assumendo che sia ordinata in ordine
  // crescente, emette nel flusso d'uscita la posizione dell'intero specificato
  // sulla linea di comando (se presente nell'input), o -1 viceversa.

  //Il metodo searchLoop è più efficiente in quanto non richiede un blocco try-catch per gestire l'eccezione IndexOutOfBoundsException.

}

/*Implement search as specified in Figure 4.1 in two ways: using for loops, and using while (true) loops that are terminated when 
accessing the array raises IndexOutOfBoundsException. Which implementation is better? Discuss. */
