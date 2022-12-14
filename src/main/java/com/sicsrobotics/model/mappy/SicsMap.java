package com.sicsrobotics.model.mappy;

import java.util.Map;

public abstract class SicsMap<K,V> implements Map<K,V> {

    public SicsMap<K,V> AddDataPair(K key, V value){

        this.put(key,value);

        return this;

    }
}
