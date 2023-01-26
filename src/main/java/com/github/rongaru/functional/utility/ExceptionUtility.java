package com.github.rongaru.functional.utility;

import com.github.rongaru.functional.interfaces.Consumer;
import com.github.rongaru.functional.interfaces.Function;
import com.github.rongaru.functional.interfaces.Supplier;

public class ExceptionUtility {

    public static < T > T throwRuntimeException( Throwable throwable ) {
        throw new RuntimeException( throwable );
    }

    public static < T > T printStackTraceAndGetNull( Throwable throwable ) {
        throwable.printStackTrace( );
        return null;
    }

    public static < T > T printStackTraceAndGetDefault( Throwable throwable, T value ) {
        throwable.printStackTrace( );
        return value;
    }

    public static void acceptException( Throwable throwable, Consumer< Throwable > consumer ) {
        try {
            consumer.accept( throwable );
        } catch ( Throwable e ) {
            throw new RuntimeException( e );
        }
    }

    public static < T > T applyException( Throwable throwable, Function< Throwable, T > function ) {
        try {
            return function.apply( throwable );
        } catch ( Throwable e ) {
            throw new RuntimeException( e );
        }
    }

    public static < T > T printStackTraceAndGetDefault( Throwable throwable, Supplier< T > supplier ) {
        try {
            throwable.printStackTrace( );
            return supplier.get( );
        } catch ( Throwable e ) {
            throw new RuntimeException( e );
        }
    }

}
