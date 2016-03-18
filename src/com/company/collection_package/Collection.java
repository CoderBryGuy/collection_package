package com.company.collection_package;

/**
 * Created by Bryan on 3/18/2016.
 */
public interface Collection{
    void add(int x);
    void add(int x, int index);
    void add(Collection collections);
    void clear();
    boolean contains(int x);
    int get(int index);

    /**
     * finds an element in the collection
     * @param x
     * @return the position of the element in the collection
     * if the element doesn't exist in the collection, -1 is returned.
     * if the element exists multiple times, the first one's position is returned
     */
    int indexOf(int x);
    int lastIndexOf(int x);
    boolean isEmpty();
    void remove(int x);
    void removeAll(int x);
    int size();
    Collection subList(int fromIndex, int toIndex);
    int[] toArray();
}