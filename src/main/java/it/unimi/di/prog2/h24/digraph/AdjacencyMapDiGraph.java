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

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * A <em>mutable</em> directed graph implementation based on a {@link Map} between nodes and their
 * <em>outgoing</em> sets.
 *
 * @param <T> the type of the graph nodes.
 */
public class AdjacencyMapDiGraph<T> implements DiGraph<T> {

  /**
   * A {@link Map} between nodes and their outgoing sets.
   *
   * <p>Every node in the graph is a key of this map, and viceversa. Isolated nodes map to {@link
   * Collections#emptySet()}.
   */
  private final Map<T, Set<T>> adjacency;

  /** Creates an empty graph. */
  public AdjacencyMapDiGraph() {
    adjacency = new HashMap<>();
  }

  /**
   * Creates a graph with the same nodes and arcs of the given graph.
   *
   * @param graph the graph to copy.
   * @throws NullPointerException if {@code graph} is {@code null}.
   */
  @SuppressWarnings("this-escape")
  public AdjacencyMapDiGraph(DiGraph<? extends T> graph) {
    this();
    DiGraph.fill(Objects.requireNonNull(graph), this);
  }

  @Override
  public void addArc(final T src, final T dst) {
    Objects.requireNonNull(dst);
    Set<T> outgoing = adjacency.get(Objects.requireNonNull(src));
    if (outgoing == null) adjacency.put(src, outgoing = new HashSet<>());
    outgoing.add(dst);
    addNode(dst);
  }

  @Override
  public void addNode(T node) {
    if (!adjacency.containsKey(Objects.requireNonNull(node))) adjacency.put(node, new HashSet<>());
  }

  @Override
  public boolean hasArc(T src, T dst) {
    Objects.requireNonNull(src);
    Objects.requireNonNull(dst);
    final Set<T> outgoing = adjacency.get(src);
    if (outgoing == null) return false;
    return outgoing.contains(dst);
  }

  @Override
  public Set<T> outgoing(T src) {
    final Set<T> outgoing = adjacency.get(Objects.requireNonNull(src));
    if (outgoing == null) return Collections.emptySet();
    return Collections.unmodifiableSet(outgoing);
  }

  @Override
  public Set<T> nodes() {
    return Collections.unmodifiableSet(adjacency.keySet());
  }
}
