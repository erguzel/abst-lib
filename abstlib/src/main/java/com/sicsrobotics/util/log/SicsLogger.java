package com.sicsrobotics.util.log;
import java.time.LocalTime;


/**
 * Generic logger
 * Instantiate in relevalt class and use
 * @param <T> Any type
 */
public class SicsLogger<T> {

    private Class<?> clazz;

    public SicsLogger(Class<?> clazz) {
        this.clazz = clazz;


    }
    /**
     * Prints log message to consol error
     * @param message message of log
     */
    public void error(String message){
        System.out.println(
                String.format(
                        "[%s] [%s] [%s]:[%s]:[%s]:[%s] - [%s]",
                        "SICSLOGGER-ERROR",
                        LocalTime.now().toString(),
                        this.clazz.getCanonicalName(),
                        Thread.currentThread().getName(),
                        Thread.currentThread().getId(),
                        Thread.currentThread().getState().name(),
                        message));
    }

    /**
     * Prints log message to consol error
     * @param message message of log
     */
    public void info(String message){
        System.out.println(
                String.format(
                        "[%s] [%s] [%s]:[%s]:[%s]:[%s] - [%s]",
                        "SICSLOGGER-INFO",
                        LocalTime.now().toString(),
                        this.clazz.getCanonicalName(),
                        Thread.currentThread().getName(),
                        Thread.currentThread().getId(),
                        Thread.currentThread().getState().name(),
                        message));
    }

    /**
     * Prints log message to consol error
     * @param message message of log
     */
    public void info(String message, boolean isVerbose){
        if(isVerbose){
            System.out.println(
                    String.format(
                            "[%s] [%s] [%s]:[%s]:[%s]:[%s] - [%s]",
                            "SICSLOGGER-INFO",
                            LocalTime.now().toString(),
                            this.clazz.getCanonicalName(),
                            Thread.currentThread().getName(),
                            Thread.currentThread().getId(),
                            Thread.currentThread().getState().name(),
                            message));
        }
    }

    /**
     * Prints log message to consol error
     * @param message message of log
     */
    public void warning(String message){
        System.out.println(
                String.format(
                        "[%s] [%s] [%s]:[%s]:[%s]:[%s] - [%s]",
                        "SICSLOGGER-WARNING",
                        LocalTime.now().toString(),
                        this.clazz.getCanonicalName(),
                        Thread.currentThread().getName(),
                        Thread.currentThread().getId(),
                        Thread.currentThread().getState().name(),
                        message));
    }


}

