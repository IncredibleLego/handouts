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

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Collection;
import java.util.Map;
import java.util.Objects;

/**
 * A collection of utilities related to {@link DiGraph}s.
 *
 * <p>This class provides a few utility methods, mainly related to <a
 * href="https://www.graphviz.org/">Graphviz</a>.
 */
public class DiGraphs {

  /** . */
  private DiGraphs() {}

  /**
   * Fills the given graph with the arcs described by the given adjacency map.
   *
   * @param <T> the type of the graph nodes.
   * @param adjacency the adjacency map.
   * @param graph the mutable graph to fill.
   * @throws NullPointerException if {@code adjacency} is or contains {@code null} or {@code graph}
   *     is {@code null}.
   * @throws UnsupportedOperationException if {@code graph} is immutable.
   */
  public static <T> void fromAdjacencyMap(
      final Map<T, Collection<T>> adjacency, final DiGraph<T> graph) {
    for (Map.Entry<T, Collection<T>> e : Objects.requireNonNull(adjacency).entrySet()) {
      T src = Objects.requireNonNull(Objects.requireNonNull(e).getKey());
      for (T dst : e.getValue()) graph.addArc(src, Objects.requireNonNull(dst));
    }
  }

  /**
   * Returns the <em>dot</em> representation of the given graph.
   *
   * @param <T> the type of the graph nodes.
   * @param graph the graph.
   * @return the <em>dot</em> representation of the given graph.
   * @throws NullPointerException if {@code graph} is {@code null}.
   */
  public static <T> String toDot(final DiGraph<T> graph) {
    return toDot(Objects.requireNonNull(graph), null);
  }

  /**
   * Returns the <em>dot</em> representation of the given graph.
   *
   * @param <T> the type of the graph nodes.
   * @param graph the graph.
   * @param extra extra configuration to be added to the <em>dot</em> source, may be {@code null}.
   * @return the <em>dot</em> representation of the given graph.
   * @throws NullPointerException if {@code graph} is {@code null}.
   */
  public static <T> String toDot(final DiGraph<T> graph, final String extra) {
    Objects.requireNonNull(graph);
    StringBuilder b = new StringBuilder();
    b.append("digraph G {\n");
    if (extra != null) b.append(extra + "\n");
    for (Arc<T> arc : graph.arcs())
      b.append(
          String.format("\t%s -> %s;\n", arc.source().toString(), arc.destination().toString()));
    b.append("}\n");
    return b.toString();
  }

  /**
   * Renders a <em>dot</em> source to a PDF file (invoking an external command).
   *
   * @param dot the <em>dot</em> source
   * @param path path of the PDF to create.
   * @throws NullPointerException if {@code dot} or {@code path} is {@code null}.
   */
  public static void dotToPdf(final String dot, final String path) {
    Objects.requireNonNull(dot);
    final ProcessBuilder pb = new ProcessBuilder("sfdp", "-T", "pdf");
    pb.redirectOutput(new File(Objects.requireNonNull(path)));
    try {
      final Process p = pb.start();
      final OutputStream os = p.getOutputStream();
      os.write(dot.getBytes());
      os.close();
      p.waitFor();
    } catch (IOException | InterruptedException e) {
      System.err.println("Something went wrong");
    }
  }
}
