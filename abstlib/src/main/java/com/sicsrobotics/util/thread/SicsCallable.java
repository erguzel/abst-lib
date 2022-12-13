package com.sicsrobotics.util.thread;

import com.sicsrobotics.util.log.SicsLogger;

import java.util.concurrent.Callable;

public abstract class SicsCallable<T> implements Callable<T> {
    public static SicsLogger<SicsCallable> LOGGER;
    private final long pseudoId;
    public SicsCallable(long pseudoId) {
        this.pseudoId = pseudoId;
        if(LOGGER == null)
            LOGGER = new SicsLogger<>(this.getClass());
    }

}
