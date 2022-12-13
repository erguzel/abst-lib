package com.sicsrobotics.util.base;

import com.sicsrobotics.util.log.SicsLogger;

public abstract class SicsObject<T> extends SicsLogger<T> {

    public static SicsLogger<?> LOGGER;

    public SicsObject(Class clazz) {
        super(clazz);
        if(LOGGER == null)
            LOGGER = new SicsLogger<>(this.getClass());
    }
}
