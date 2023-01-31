package com.github.rongaru.functional.executors;

import com.github.rongaru.functional.exceptional.ExceptionalTriFunction;
import com.github.rongaru.functional.interfaces.QuadFunction;
import com.github.rongaru.functional.interfaces.TriFunction;

import java.util.function.Supplier;

public class ExceptionalTriFunctionExecutor {

    public static < T, U, V, R > R execute( T var1, U var2, V var3, ExceptionalTriFunction< T, U, V, R > function ) {
        try {
            return function.apply( var1, var2, var3 );
        } catch ( Throwable e ) {
            throw new RuntimeException( e );
        }
    }

    public static < T, U, V, R > R executeOrElse( T var1, U var2, V var3, ExceptionalTriFunction< T, U, V, R > function, R value ) {
        try {
            return function.apply( var1, var2, var3 );
        } catch ( Throwable e ) {
            e.printStackTrace( );
            return value;
        }
    }

    public static < T, U, V, R > R executeOrElse( T var1, U var2, V var3, ExceptionalTriFunction< T, U, V, R > function, Supplier< R > supplier ) {
        try {
            return function.apply( var1, var2, var3 );
        } catch ( Throwable e ) {
            e.printStackTrace( );
            return supplier.get( );
        }
    }

    public static < T, U, V, R > R executeOrElse( T var1, U var2, V var3, ExceptionalTriFunction< T, U, V, R > function, TriFunction< T, U, V, R > exceptional ) {
        try {
            return function.apply( var1, var2, var3 );
        } catch ( Throwable e ) {
            e.printStackTrace( );
            return exceptional.apply( var1, var2, var3 );
        }
    }

    public static < T, U, V, R > R executeOrElse( T var1, U var2, V var3, ExceptionalTriFunction< T, U, V, R > function, QuadFunction< T, U, V, Throwable, R > exceptional ) {
        try {
            return function.apply( var1, var2, var3 );
        } catch ( Throwable e ) {
            e.printStackTrace( );
            return exceptional.apply( var1, var2, var3, e );
        }
    }

}
