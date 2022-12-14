package com.sicsrobotics.util.thread;

import com.sicsrobotics.util.log.SicsLogger;

public class SicsThread extends Thread{
    public static SicsLogger<SicsThread> LOGGER = null;
    private long pseudoId = -1;
    public long getPseudoId() {
        return pseudoId;
    }

    public SicsThread(long pseudoId) {
        this.pseudoId = pseudoId;
        if(LOGGER == null)
            LOGGER = new SicsLogger<>(this.getClass());
    }
}
