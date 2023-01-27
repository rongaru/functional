package com.github.rongaru.functional.utility;

public class ExceptionUtility {

    public static < T > T throwRuntimeException( Throwable e ) {
        throw new RuntimeException( e );
    }

    public static < T > T printStackTraceAndGetNull( Throwable e ) {
        e.printStackTrace( );
        return null;
    }

    public static < T > T printStackTraceAndGetDefault( T var, Throwable e ) {
        e.printStackTrace( );
        return var;
    }

}
