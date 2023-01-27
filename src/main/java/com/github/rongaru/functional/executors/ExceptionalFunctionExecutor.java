package com.github.rongaru.functional.executors;

import com.github.rongaru.functional.exceptional.ExceptionalFunction;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class ExceptionalFunctionExecutor {

    public static < T, R > R execute( T var, ExceptionalFunction< T, R > function ) {
        try {
            return function.apply( var );
        } catch ( Throwable e ) {
            throw new RuntimeException( e );
        }
    }

    public static < T, R > R executeOrElse( T var, ExceptionalFunction< T, R > function, R value ) {
        try {
            return function.apply( var );
        } catch ( Throwable e ) {
            e.printStackTrace( );
            return value;
        }
    }

    public static < T, R > R executeOrElse( T var, ExceptionalFunction< T, R > function, Supplier< R > supplier ) {
        try {
            return function.apply( var );
        } catch ( Throwable e ) {
            e.printStackTrace( );
            return supplier.get( );
        }
    }

    public static < T, R > R executeOrElse( T var, ExceptionalFunction< T, R > function, Function< T, R > exceptional ) {
        try {
            return function.apply( var );
        } catch ( Throwable e ) {
            e.printStackTrace( );
            return exceptional.apply( var );
        }
    }

    public static < T, R > R executeOrElse( T var, ExceptionalFunction< T, R > function, BiFunction< T, Throwable, R > exceptional ) {
        try {
            return function.apply( var );
        } catch ( Throwable e ) {
            e.printStackTrace( );
            return exceptional.apply( var, e );
        }
    }

}
