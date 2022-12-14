package com.sicsrobotics.model.setty;

import java.util.Set;

public abstract class SicsSet<T> implements Set<T> {

    public SicsSet<T> addFluent(T element){

        this.add(element);
        return this;
    }
}
