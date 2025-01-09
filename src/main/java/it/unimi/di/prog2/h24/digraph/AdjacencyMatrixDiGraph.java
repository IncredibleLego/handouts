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

package it.unimi.di.prog2.h24.digraph;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

/**
 * A partially <em>mutable</em> directed graph implementation based on an adjacency matrix.
 *
 * <p>This implementation is <em>partially</em> mutable: the set of nodes is fixed at construction
 * time, while arcs can be added at any time.
 *
 * @param <T> the type of the nodes of the graph.
 */
public class AdjacencyMatrixDiGraph<T> implements DiGraph<T> {

  /** The nodes of the graph, in some order. */
  private final List<T> nodes;

  /** The adjacency matrix. */
  private final boolean[][] adjacencyMatrix;

  /**
   * Creates a graph with the given nodes.
   *
   * @param nodes the nodes of the graph.
   * @throws NullPointerException if {@code nodes} is, or contains, {@code null}.
   */
  public AdjacencyMatrixDiGraph(Set<? extends T> nodes) {
    this.nodes = List.copyOf(Objects.requireNonNull(nodes));
    adjacencyMatrix = new boolean[nodes.size()][nodes.size()];
  }

  /**
   * Creates a graph with the same nodes and arcs of the given graph.
   *
   * @param graph the graph to copy.
   * @throws NullPointerException if {@code graph} is {@code null}.
   */
  @SuppressWarnings("this-escape")
  public AdjacencyMatrixDiGraph(DiGraph<? extends T> graph) {
    this(Objects.requireNonNull(graph).nodes());
    DiGraph.fill(graph, this);
  }

  @Override
  public Set<T> nodes() {
    return Set.copyOf(nodes);
  }

  @Override
  public void addNode(T node) {
    if (!nodes.contains(Objects.requireNonNull(node))) throw new UnsupportedOperationException();
  }

  @Override
  public void addArc(T source, T destination) {
    if (!nodes.contains(Objects.requireNonNull(source))
        || !nodes.contains(Objects.requireNonNull(destination)))
      throw new UnsupportedOperationException();
    adjacencyMatrix[nodes.indexOf(source)][nodes.indexOf(destination)] = true;
  }

  @Override
  public Set<T> outgoing(T source) {
    if (!nodes.contains(Objects.requireNonNull(source))) throw new IllegalArgumentException();
    return new AbstractSet<T>() {

      final int sourceIndex = nodes.indexOf(source);

      @Override
      public Iterator<T> iterator() {
        return new Iterator<>() {
          int destinationIndex = 0;

          @Override
          public boolean hasNext() {
            while (destinationIndex < adjacencyMatrix[sourceIndex].length
                && !adjacencyMatrix[sourceIndex][destinationIndex]) destinationIndex++;
            return destinationIndex < adjacencyMatrix[sourceIndex].length;
          }

          @Override
          public T next() {
            if (!hasNext()) throw new NoSuchElementException();
            int next = destinationIndex;
            destinationIndex++;
            return nodes.get(next);
          }
        };
      }

      @Override
      public int size() {
        int count = 0;
        for (int i = 0; i < adjacencyMatrix[sourceIndex].length; i++)
          if (adjacencyMatrix[sourceIndex][i]) count++;
        return count;
      }
    };
  }
}
