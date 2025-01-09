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

import java.util.Objects;

/**
 * An arc of a directed graph with nodes of type {@code T}.
 *
 * <p>This class is <em>immutable</em>, two arcs are equal if and only if their sources and
 * destinations are respectively equal.
 *
 * @param <T> the type of the graph nodes.
 * @param source the arc source.
 * @param destination the arc destination.
 */
public record Arc<T>(T source, T destination) {

  /**
   * Creates an arc.
   *
   * @param source the arc source.
   * @param destination the arc destination.
   * @throws NullPointerException if {@code source} or {@code destination} is {@code null}.
   */
  public Arc {
    Objects.requireNonNull(source);
    Objects.requireNonNull(destination);
  }

  public String toString() {
    return String.format("(%s, %s)", source.toString(), destination.toString());
  }
}
