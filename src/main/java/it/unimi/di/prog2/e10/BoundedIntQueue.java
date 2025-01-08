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

package it.unimi.di.prog2.e10;

/**
 * A <em>queue</em> is a mutable data structure that provides access to its elements in
 * first-in/first-out order.
 *
 * <p>A <em>bounded</em> queue has an upper bound, established when a queue is created, on the
 * number of elements that can be stored in the queue.
 */
public class BoundedIntQueue {

  // EXERCISE: complete following the specification (with particular attention
  // to the eventual exceptions) and provide an implementation (including the
  // equals, hashCode, and toString methods); add methods that are adequate to
  // the specification.

  // Given the boundedness constraint, it is not allowed to use any Java
  // Collection Framework class. An array can be used to store the elements in a
  // circular buffer (see https://www.wikiwand.com/en/articles/Circular_buffer).

  //Fields

  /**
   * The array that stores the elements of the queue.
   */
  private final int[] queue;

  /**
   * The index of the first element in the queue.
   */
  private int start;

  /**
   * The number of elements in the queue.
   */
  private int size;

  //Constructors

  /**
   * Creates a new bounded queue with the given capacity.
   *
   * @param capacity the capacity of the queue.
   * @throws IllegalArgumentException if {@code capacity} is negative.
   */
  public BoundedIntQueue(int capacity) {
    if (capacity < 0) {
      throw new IllegalArgumentException("Capacity must be non-negative");
    }
    queue = new int[capacity];
    start = 0;
    size = 0;
  }

  //Methods

  /**
   * Adds an element to the queue.
   *
   * @param x the element to add.
   * @throws IllegalStateException if the queue is full.
   */
  public void enqueue(int x) {
    //REQUIRES: x is an integer
    //MODIFIES: this
    //EFFECTS: if the queue is full throws an exception, otherwise adds x to the queue
    if (size == queue.length) {
      throw new IllegalStateException("Queue is full");
    }
    for (int i = start; i < queue.length; i++) {
      if (queue[i] == 0){
        queue[i] = x;
        break;
      }
    }
    size++;
  }

  /**
   * Removes the element at the head of the queue.
   *
   * @return the element at the head of the queue.
   * @throws IllegalStateException if the queue is empty.
   */
  public int dequeue() {
    //MODIFIES: this
    //EFFECTS: if the queue is empty throws an exception, otherwise removes the element at the head of the queue
    if (size == 0) {
      throw new IllegalStateException("queue is empty");
    }
    int element = queue[start];
    start = (start + 1) % queue.length;
    size--;
    return element;
  }

  /**
   * Overrides the default {@link Object#toString()} method to provide a string representation of the
   * queue that starts with "BountedIntQueue: [" and lists the elements in the queue separated by
   * commas. If the queue is empty, the string representation is "BoundedIntQueue: []".
   *
   * @return the number of elements in the queue.
   */
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("BoundedIntQueue: [");
    if (queue[start] != 0) sb.append(queue[start]);
    for (int i = 1; i<size ; i++) {
      int index = (start+i)%queue.length;
      sb.append(", ").append(String.valueOf(queue[index]));
    }
    sb.append("]");
    return sb.toString();
  }

  @Override
  public boolean equals(Object obj) {
      if (obj == null || !(obj instanceof BoundedIntQueue obj2) || obj2.size != size){
        return false;
      }
      return obj.equals(toString());
  }

  @Override
  public int hashCode() {
    int result = 0;
    for (int i = 0; i < queue.length; i++) {
      int index = (start+i)%queue.length;
      result = queue[index]*queue[start] + Integer.hashCode(queue[index]);
    }
    return result; 
  }
}
