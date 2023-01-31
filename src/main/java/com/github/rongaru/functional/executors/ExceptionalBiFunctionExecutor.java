package com.github.rongaru.functional.executors;

import com.github.rongaru.functional.exceptional.ExceptionalBiFunction;
import com.github.rongaru.functional.interfaces.TriFunction;

import java.util.function.BiFunction;
import java.util.function.Supplier;

public class ExceptionalBiFunctionExecutor {

    public static < T, U, R > R execute( T var1, U var2, ExceptionalBiFunction< T, U, R > function ) {
        try {
            return function.apply( var1, var2 );
        } catch ( Throwable e ) {
            throw new RuntimeException( e );
        }
    }

    public static < T, U, R > R executeOrElse( T var1, U var2, ExceptionalBiFunction< T, U, R > function, R value ) {
        try {
            return function.apply( var1, var2 );
        } catch ( Throwable e ) {
            e.printStackTrace( );
            return value;
        }
    }

    public static < T, U, R > R executeOrElse( T var1, U var2, ExceptionalBiFunction< T, U, R > function, Supplier< R > supplier ) {
        try {
            return function.apply( var1, var2 );
        } catch ( Throwable e ) {
            e.printStackTrace( );
            return supplier.get( );
        }
    }

    public static < T, U, R > R executeOrElse( T var1, U var2, ExceptionalBiFunction< T, U, R > function, BiFunction< T, U, R > exceptional ) {
        try {
            return function.apply( var1, var2 );
        } catch ( Throwable e ) {
            e.printStackTrace( );
            return exceptional.apply( var1, var2 );
        }
    }

    public static < T, U, R > R executeOrElse( T var1, U var2, ExceptionalBiFunction< T, U, R > function, TriFunction< T, U, Throwable, R > exceptional ) {
        try {
            return function.apply( var1, var2 );
        } catch ( Throwable e ) {
            e.printStackTrace( );
            return exceptional.apply( var1, var2, e );
        }
    }

}
