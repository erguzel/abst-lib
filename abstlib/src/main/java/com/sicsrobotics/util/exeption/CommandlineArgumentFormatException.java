package com.sicsrobotics.util.exeption;

public class CommandlineArgumentFormatException extends SicsException{
    public CommandlineArgumentFormatException(String message, Throwable cause, boolean _killApp, boolean _throwIt, boolean _logIt) {
        super(message, cause, _killApp, _throwIt, _logIt);
    }
}
