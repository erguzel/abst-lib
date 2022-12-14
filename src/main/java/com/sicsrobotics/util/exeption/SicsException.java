package com.sicsrobotics.util.exeption;

import com.sicsrobotics.model.mappy.SicsMapEntry;
import com.sicsrobotics.util.log.SicsLogger;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class SicsException extends RuntimeException {

    private SicsLogger<SicsException> LOGGER = new SicsLogger<>(SicsException.class);
    private final LinkedHashMap<Object, Object> _exceptionData = new LinkedHashMap<>();
    private boolean _killApp;
    private boolean _throwIt;
    private boolean _logIt;

    public SicsException(String message, Throwable cause, boolean _killApp, boolean _throwIt, boolean _logIt) {
        super(message, cause);
        this._killApp = _killApp;
        this._throwIt = _throwIt;
        this._logIt = _logIt;
        LOGGER = new SicsLogger<>(this.getClass());
    }

    public Map<Object,Object> getData(){
        return this._exceptionData;
    }

    public SicsException AddTada(SicsMapEntry<?, ?> dataPair) {
        this._exceptionData.put(dataPair.getKey(), dataPair.getValue());
        return this;
    }

    public SicsException AddDataPair(Object key, Object value) {
        this._exceptionData.put(key, value);
        return this;
    }

    public void Log() {

        boolean nullCause = this.getCause() == null;
        boolean logData = this._exceptionData.size()>0;

        LOGGER.error(
                String.format(
                                "\n-----START-----%1$s-----START-----\n"+
                                "\t - Message: %2$s\n"+
                                "\t - InnerType: %3$s\n" +
                                "\t - InnerMessage: %4$s\n" +
                                "\t - lastStackTraceElement: %5$s\n"+
                                        "\t - StackTrace: \n%6$s\n"+
                                        "\t - InnerStackTrace: \n%7$s\n"+
                                        "\t - CUSTOMDATA:\n" +
                                        "\t  %8$s\n"+
                                        "--------END-----%1$s--------\t%9$s",
                        this.getClass().getSimpleName(),
                        this.getMessage(),
                        nullCause?"NONE":this.getCause().getClass().getSimpleName(),
                        nullCause?"NONE":this.getCause().getMessage(),
                        this.getStackTrace()[0].toString(),
                      //  this.getStackTrace()[this.getStackTrace().length - 1].toString(),
                        Arrays.stream(this.getStackTrace()).map(a -> "\t\t" + a.toString()).collect(Collectors.joining("\n")),
                        nullCause?"\t\tNONE":
                                Arrays.stream(this.getCause().getStackTrace()).map(a -> "\t\t" + a.toString()).collect(Collectors.joining("\n")),
                        logData?
                                this._exceptionData.entrySet().stream().map(a -> "\t\t" + a.getKey() + ": " + a.getValue()).collect(Collectors.joining("\n\t"))+"\n":"NONE",
                        _killApp?"Terminating application":""
                )
        );

    }
    public void Act() throws SicsException {
        if (this._logIt) {
            this.Log();
        }
        if (this._killApp) {
            System.exit(0);
        }
        if (this._throwIt)
            throw this;
    }
    public void Act(boolean withoutThrowSignature){
        if (this._logIt) {
            this.Log();
        }
        if (this._killApp) {
            System.exit(0);
        }
    }

    public static void Handle(String message,
                                       boolean killApp,
                                       boolean logIt,
                                       boolean throwIt, Throwable t) throws SicsException {

        SicsException em = null;
        boolean shouldPatch = t!=null &&
                (t.getClass().getSuperclass() == SicsException.class
                || t.getClass() == SicsException.class);


        if (shouldPatch) {
            em = (SicsException) t;
            em._killApp = killApp;
            em._logIt = logIt;
            em._throwIt = throwIt;

        } else {
            em = new SicsException(message, t, killApp, throwIt, logIt);
        }


        em.Act();
    }


    public static void HandleSlient(String message,
                                       boolean killApp,
                                       boolean logIt, Throwable t) {

        SicsException em = null;
        boolean shouldPatch = t!=null &&
                (t.getClass().getSuperclass() == SicsException.class
                        || t.getClass() == SicsException.class);


        if (shouldPatch) {
            em = (SicsException) t;
            em._killApp = killApp;
            em._logIt = logIt;
            em._throwIt = false;

        } else {
            em = new SicsException(message, t, killApp, false, logIt);
        }
        em.Act(true);
    }

}







































