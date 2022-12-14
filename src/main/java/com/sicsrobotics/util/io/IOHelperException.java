package com.sicsrobotics.util.io;

import com.sicsrobotics.util.exeption.SicsException;

public class IOHelperException extends SicsException {

    public IOHelperException(String message, Throwable cause, boolean _killApp, boolean _throwIt, boolean _logIt) {
        super(message, cause, _killApp, _throwIt, _logIt);
    }
}
