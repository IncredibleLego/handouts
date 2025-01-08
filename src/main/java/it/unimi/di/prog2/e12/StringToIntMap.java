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

package it.unimi.di.prog2.e12;

import java.util.NoSuchElementException;

/**
 * A map from {@link String} to {@link Integer}.
 *
 * <p>A <em>map</em> is a collection that associates keys to values. In this case, the keys are
 * strings and the values are integers. The map cannot contain duplicate keys, which means that each
 * key can be associated to at most one value.
 */
public class StringToIntMap {

  // EXERCISE: provide a representation, together with its AF and RI
  // Note: do not use the Map in Java Collections, the point is to implement it from scratch!

  //Fields

  /**
   * The keys of this map.
   */
  private String[] keys;

  /**
   * The values of this map.
   */
  private int[] values;

  //Constructor

  /** Creates a new empty map. */
  public StringToIntMap() {
    keys = new String[0];
    values = new int[0];
  }

  /**
   * Returns the size of this map.
   *
   * @return the number of key-value mappings in this map.
   */
  public int size() {
    return keys.length;
  }

  /**
   * Returns if this map is empty.
   *
   * @return {@code true} if this map contains no key-value mappings.
   */
  public boolean isEmpty() {
    return keys.length == 0;
  }

  /**
   * Returns if this map contains the specified key.
   *
   * @param key the key to search for.
   * @return {@code true} iff this map contains a key-value mappings with the given {@code key}.
   */
  public boolean containsKey(String key) {
    for (String k : keys) {
      if (k.equals(key)) {
        return true;
      }
    }
    return false;
  }

  /**
   * Returns if this map contains the specified value.
   *
   * @param value the value to search for.
   * @return {@code true} iff this map contains a key-value mappings with the given {@code value}.
   */
  public boolean containsValue(int value) {
    for (int v : values) {
      if (v == value) {
        return true;
      }
    }
    return false;
  }

  /**
   * Returns the value to which the specified key is mapped.
   *
   * @param key the key whose associated value is to be returned.
   * @return the value to which the specified key is mapped.
   * @throws NoSuchElementException if this map contains no mapping for the key, or the key is
   *     {@code null}.
   */
  public int get(String key) throws NoSuchElementException {
    for (int i = 0; i < keys.length; i++) {
      if (keys[i].equals(key)) {
        return values[i];
      }
    }
    throw new NoSuchElementException();
  }

  /**
   * Associates in this map the new key with the specified value.
   *
   * @param key the key with which the specified value is to be associated.
   * @param value the value to be associated with the specified key.
   * @throws IllegalArgumentException if the map already contain a mapping for the key.
   * @throws NullPointerException if the key is {@code null}.
   */
  public void put(String key, int value) {
    if (key == null) {
      throw new NullPointerException();
    }
    if (containsKey(key)) {
      throw new IllegalArgumentException();
    }
    String[] newKeys = new String[keys.length + 1];
    int[] newValues = new int[values.length + 1];
    for (int i = 0; i < keys.length; i++) {
      newKeys[i] = keys[i];
      newValues[i] = values[i];
    }
    newKeys[keys.length] = key;
    newValues[values.length] = value;
    keys = newKeys;
    values = newValues;
  }

  /**
   * Removes the mapping for a key from this map if it is present.
   *
   * @param key the key whose mapping is to be removed from the map.
   * @return {@code true} iff this map contained a mapping for the specified key, and hence is
   *     modified by this operation.
   */
  public boolean remove(String key) {
    if (!containsKey(key)) {
      return false;
    }
    String[] newKeys = new String[keys.length - 1];
    int[] newValues = new int[values.length - 1];
    int j = 0;
    for (int i = 0; i < keys.length; i++) {
      if (!keys[i].equals(key)) {
        newKeys[j] = keys[i];
        newValues[j] = values[i];
        j++;
      }
    }
    keys = newKeys;
    values = newValues;
    return true;
  }

  /** Removes all of the mappings from this map. */
  public void clear() {
    keys = new String[0];
    values = new int[0];
  }
}