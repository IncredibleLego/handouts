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

package it.unimi.di.prog2.e17;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A class to handle a list of rectangles and organize them as in histogram.
 *
 * <p>The rectangles are organized in decreasing height order, more specifically the iterator
 * returns the rectangles in this order.
 */
public class Histogram implements Iterable<Rectangle> {

  private final List<Rectangle> rectangles;

  /** Creates an empty histogram. */
  public Histogram() {
    this.rectangles = new ArrayList<>();
  }

  /**
   * Adds a {@link Rectangle} to this histogram.
   *
   * @param rectangle the rectangle to add.
   */
  public void add(Rectangle rectangle) {
    rectangles.add(rectangle);
    rectangles.sort((r1, r2) -> Integer.compare(r2.height(), r1.height()));
  }

  /**
   * Changes the base of the given rectangle
   *
   * @param rectangle the rectangle.
   * @param newBase the new base.
   * @throws NoSuchElementException if the rectangle is not in the histogram.
   */
  public void changeBase(Rectangle rectangle, int newBase) {
    if (!rectangles.contains(rectangle)) {
      throw new NoSuchElementException("Rectangle not found in histogram");
    }
    rectangle.setBase(newBase);
    rectangles.sort((r1, r2) -> Integer.compare(r2.height(), r1.height()));
  }

  /**
   * Returns an iterator that produces the rectangles in this histogram in decreasing height order.
   *
   * @return the iterator over the rectangles in this histogram.
   */
  @Override
  public Iterator<Rectangle> iterator() {
    return Collections.unmodifiableList(rectangles).iterator();
  }
}
