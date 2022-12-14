package com.sicsrobotics.model.listy;

import java.util.List;

public abstract class SicsList<T> implements List<T> {

    public SicsList<T> AddFluent(T element){
        this.add(element);
        return this;
    }

}
