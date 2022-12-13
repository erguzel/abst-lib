package com.sicsrobotics.util.exeption;

import com.sicsrobotics.util.exeption.SicsException;

public class InputFileNotFoundException extends SicsException {


    public InputFileNotFoundException(String message, Throwable cause, boolean _killApp, boolean _throwIt, boolean _logIt) {
        super(message, cause, _killApp, _throwIt, _logIt);
    }

}
