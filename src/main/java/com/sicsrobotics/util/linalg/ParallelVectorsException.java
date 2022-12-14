package com.sicsrobotics.util.linalg;

import com.sicsrobotics.util.exeption.SicsException;

public class ParallelVectorsException extends SicsException {

    public ParallelVectorsException(String message, Throwable cause, boolean _killApp, boolean _throwIt, boolean _logIt) {
        super(message, cause, _killApp, _throwIt, _logIt);
    }
}
