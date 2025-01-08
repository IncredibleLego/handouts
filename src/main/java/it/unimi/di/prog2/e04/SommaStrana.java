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
 * href="https://github.com/mapio/labprog/blob/master/esercizi/somma_strana/Testo.md">testo</a>, ma
 * leggendo gli addendi dal flusso di ingresso.
 * 
 * @author Corrado Francesco Emanuele
 */
public class SommaStrana {
  /**
   * Makes a Strange Sum Between two numbers
   * 
   * <p> Takes two numbers and sums them in colon, but when the sum is >9, the sum becomes 9 - result
   * 
   * @param args the two numbers to sum
   */
  public static void main(String[] args){
    //REQUIRES: System.in, System.out
    //MODIFIES: System.out
    //EFFECTS: Gets two numbers in input and sums them with a "StrangeSum" method
    String[] valori = new String[2];
    int x=0;
    try (Scanner s = new Scanner(System.in)) {
      while (s.hasNext()) {

        String linea = s.nextLine();
        valori[x] = linea;
        x++;
      }
      char[] primoArray = valori[0].toCharArray();
      char[] secondoArray = valori[1].toCharArray();
      int maxLength = Math.max(primoArray.length, secondoArray.length);
      int[] numero1 = new int[maxLength];
      int[] numero2 = new int[maxLength];
      int[] risultato = new int[maxLength];
      for (int i = 0; i < maxLength; i++) {
        if (i < maxLength - primoArray.length) {
          numero1[i] = 0;
        } else {
        numero1[i] = Character.getNumericValue(primoArray[i - (maxLength - primoArray.length)]);
        }
      }
      for (int i = 0; i < maxLength; i++) {
        if (i < maxLength - secondoArray.length) {
         numero2[i] = 0;
         } else {
           numero2[i] = Character.getNumericValue(secondoArray[i - (maxLength - secondoArray.length)]);
          }
        }
        for (int i=risultato.length-1; i > -1; i--){
          int somma = numero1[i] + numero2[i];
          if (somma < 10){
            risultato[i] = somma;
          }else{
            risultato[i] = 9-(somma-10);
            if (i == 0){
              risultato[i] += 10;
            }else{
              numero1[i-1]++;
            }
          }
        }
        System.out.print(Arrays.toString(risultato).replace("[", "").replace("]", "").replace(", ", ""));
    }
  }

  // Per memorizzare un elenco di interi si può usare list<Integer>, grazie
  // all'boxing automatico https://dev.java/learn/numbers-strings/autoboxing/
  // se la lista è stata dichiarata come
  //
  // List<Integer> interi = new ArrayList<>();
  //
  // sono legittime espressioni del tipo
  //
  // interi.add(3);
  // int y = interi.get(0);
  //
  // dove vengono messi e prelevati dalla lista degli int, non degli Integer.

  /** . */
  private SommaStrana() {}
}


/* VERSIONE CON LE LISTE
package it.unimi.di.prog2.e04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
*/
/**
 * Vedi <a
 * href="https://github.com/mapio/labprog/blob/master/esercizi/somma_strana/Testo.md">testo</a>, ma
 * leggendo gli addendi dal flusso di ingresso.
 * 
 * @author Corrado Francesco Emanuele
 */ /* 
public class SommaStrana {

  public static List<Integer> stringToList(String numero) {
    List<Integer> lista = new ArrayList<>();
    for (char c : numero.toCharArray()) {
        lista.add(Character.getNumericValue(c));
    }
    return lista;
  }

  public static List<Integer> strangeSum(List<Integer> lista1, List<Integer> lista2){
    while (lista1.size() < lista2.size()) {
      lista1.add(0, 0);
    }
    while (lista2.size() < lista1.size()) {
        lista2.add(0, 0);
    }
    List<Integer> risultato = new ArrayList<>();
    int riporto=0;
    for (int i = lista1.size() - 1; i >= 0; i--) {
      int somma = lista1.get(i) + lista2.get(i) + riporto;
      int cifra = somma % 10;
      riporto = somma / 10;
      if (riporto > 0) {
          cifra = 9 - cifra;
      }

      risultato.add(cifra);
    }
    if (riporto > 0) {
        risultato.add(riporto);
    }
    Collections.reverse(risultato);
    return risultato;
  }

  public static int listaToIntero(List<Integer> lista) {
    StringBuilder sb = new StringBuilder();
    for (int cifra : lista) {
        sb.append(cifra);
    }
    return Integer.parseInt(sb.toString());
}

  public static void main(String []args){
    String[] numeri = new String[2];
    int x=0;
    try (Scanner s = new Scanner(System.in)){
      while(s.hasNext()){
        String numero = s.nextLine();
        numeri[x] = numero;
        x++;
      }
    }
    List<Integer> numero1 = stringToList(numeri[0]);
    List<Integer> numero2 = stringToList(numeri[1]);
    List<Integer> risultato = strangeSum(numero1, numero2);
    int risultatoIntero = listaToIntero(risultato);
    System.out.println(risultatoIntero);
  }


  // Per memorizzare un elenco di interi si può usare list<Integer>, grazie
  // all'boxing automatico https://dev.java/learn/numbers-strings/autoboxing/
  // se la lista è stata dichiarata come
  //
  // List<Integer> interi = new ArrayList<>();
  //
  // sono legittime espressioni del tipo
  //
  // interi.add(3);
  // int y = interi.get(0);
  //
  // dove vengono messi e prelevati dalla lista degli int, non degli Integer.
*/
  /** . */ /* 
  private SommaStrana() {}

} */