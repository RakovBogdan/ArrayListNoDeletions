package org.bohdanrakov;

import java.util.*;

public class ArrayListNoDeletions<E> extends AbstractList<E> implements List<E> {

    private static final int DEFAULT_CAPACITY = 15;

    private static final Object[] EMPTY_ELEMENTDATA = {};
    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};

    private int size;

    private transient Object[] elementData;

    public ArrayListNoDeletions(int initialCapacity) {
        if (initialCapacity > 0) {
            this.elementData = new Object[initialCapacity];
        } else if (initialCapacity == 0) {
            this.elementData = EMPTY_ELEMENTDATA;
        } else {
            throw new IllegalArgumentException("Illegal Capacity: "+
                    initialCapacity);
        }
    }

    public ArrayListNoDeletions() {
        this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }

    public boolean add(E e) {
        ensureCapacity(size + 1);
        elementData[size++] = e;
        return true;
    }


    private void grow(int minCapacity) {
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        if (newCapacity - minCapacity < 0)
            newCapacity = minCapacity;
        elementData = Arrays.copyOf(elementData, newCapacity);
    }

    private void ensureCapacity(int minCapacity) {
        if (elementData == EMPTY_ELEMENTDATA) {
            minCapacity = Math.max(DEFAULT_CAPACITY, minCapacity);
        }
        if (minCapacity - elementData.length > 0)
            grow(minCapacity);
    }


    @Override
    public E remove(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public E get(int index) {
        if (index >= size){
            throw new ArrayIndexOutOfBoundsException("index " + index + " is out of bounds");
        }

        return (E)elementData[index];
    }

    @Override
    public int size() {
        return size;
    }
}
