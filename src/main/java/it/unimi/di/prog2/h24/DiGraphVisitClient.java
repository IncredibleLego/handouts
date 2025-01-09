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

package it.unimi.di.prog2.h24;

import it.unimi.di.prog2.h24.digraph.ArcListDiGraph;
import it.unimi.di.prog2.h24.digraph.Consumers;
import it.unimi.di.prog2.h24.digraph.DiGraph;
import it.unimi.di.prog2.h24.digraph.Queues;
import java.util.Queue;
import java.util.Scanner;

/** Tests <em>directed graph</em> package with visits. */
public class DiGraphVisitClient {

  /** . */
  private DiGraphVisitClient() {}

  /**
   * Returns a copy of the given DiGraph using the specified implementation.
   *
   * @param <T> the type of the nodes of the graph.
   * @param className the name of the DiGraph implementation class (e.g. {@code
   *     AdjacencyMatrixDiGraph}).
   * @param graph the graph to be copied.
   * @return a copy of {@code graph}, as an instance of a class of the given {@code className}.
   * @throws IllegalArgumentException if the class or constructor cannot be found.
   */
  @SuppressWarnings("unchecked")
  private static <T> DiGraph<T> copyAs(String className, DiGraph<T> graph)
      throws IllegalArgumentException {
    try {
      // the following lines use The Reflection API (see
      // https://docs.oracle.com/javase/tutorial/reflect/)
      Class<?> clazz = Class.forName("it.unimi.di.prog2.h24.digraph." + className);
      return (DiGraph<T>) clazz.getConstructor(DiGraph.class).newInstance(graph);
    } catch (Exception e) {
      throw new IllegalArgumentException("Problems with class: " + className, e);
    }
  }

  /**
   * Reads a graph from the standard input and performs a visit.
   *
   * <p>More precisely:
   *
   * <ul>
   *   <li>builds a graph by reading a sequence of lines, each containing two strings separated by a
   *       space corresponding to the source and destination of an arc; the first source will be the
   *       starting node of the visit;
   *   <li>then it creates a copy of the above graph using the first command line argument as the
   *       name of the class of the implementation of the graph (e.g., {@code
   *       AdjacencyMatrixDiGraph});
   *   <li>then it performs a visit using a {@link Queue} supplier that is either a {@link
   *       Queues#FIFOSupplier()} or a {@link Queues#LIFOSupplier()}) according to the first letter
   *       of the second command line argument.
   * </ul>
   *
   * @param args see the above description.
   */
  public static void main(String[] args) {
    final DiGraph<String> tempGraph = new ArcListDiGraph<>();
    String start = null;
    try (Scanner s = new Scanner(System.in)) {
      while (s.hasNextLine()) {
        final String[] srcDst = s.nextLine().trim().split("\\s+");
        tempGraph.addArc(srcDst[0], srcDst[1]);
        if (start == null) start = srcDst[0];
      }
    }
    final DiGraph<String> graph = copyAs(args[0], tempGraph);
    graph.visit(
        start,
        Consumers.printConsumer(),
        args[1].charAt(0) == 'F' ? Queues.FIFOSupplier() : Queues.LIFOSupplier());
  }
}
