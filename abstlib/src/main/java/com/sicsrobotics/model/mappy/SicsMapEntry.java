package com.sicsrobotics.model.mappy;

import java.util.Map;

public class SicsMapEntry<T,V> implements Map.Entry<T,V> {

    private final T key;
    private V value;

    public SicsMapEntry(T key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public T getKey() {
        return this.key;
    }

    @Override
    public V getValue() {
        return this.value;
    }

    @Override
    public V setValue(V value) {
       this.value = value;
       return this.value;
    }
}
