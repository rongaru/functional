package com.github.rongaru.functional.executors;

import com.github.rongaru.functional.exceptional.ExceptionalTriPredicate;
import com.github.rongaru.functional.interfaces.QuadPredicate;
import com.github.rongaru.functional.interfaces.TriPredicate;

import java.util.function.Supplier;

public class ExceptionalTriPredicateExecutor {

    public static < T, U, V > boolean execute( T var1, U var2, V var3, ExceptionalTriPredicate< T, U, V > predicate ) {
        try {
            return predicate.test( var1, var2, var3 );
        } catch ( Throwable e ) {
            e.printStackTrace( );
            throw new RuntimeException( e );
        }
    }

    public static < T, U, V > boolean executeOrElse( T var1, U var2, V var3, ExceptionalTriPredicate< T, U, V > predicate, boolean value ) {
        try {
            return predicate.test( var1, var2, var3 );
        } catch ( Throwable e ) {
            e.printStackTrace( );
            return value;
        }
    }

    public static < T, U, V > boolean executeOrElse( T var1, U var2, V var3, ExceptionalTriPredicate< T, U, V > predicate, Supplier< Boolean > supplier ) {
        try {
            return predicate.test( var1, var2, var3 );
        } catch ( Throwable e ) {
            e.printStackTrace( );
            return supplier.get( );
        }
    }

    public static < T, U, V > boolean executeOrElse( T var1, U var2, V var3, ExceptionalTriPredicate< T, U, V > predicate, TriPredicate< T, U, V > exceptional ) {
        try {
            return predicate.test( var1, var2, var3 );
        } catch ( Throwable e ) {
            e.printStackTrace( );
            return exceptional.test( var1, var2, var3 );
        }
    }

    public static < T, U, V > boolean executeOrElse( T var1, U var2, V var3, ExceptionalTriPredicate< T, U, V > predicate, QuadPredicate< T, U, V, Throwable > exceptional ) {
        try {
            return predicate.test( var1, var2, var3 );
        } catch ( Throwable e ) {
            e.printStackTrace( );
            return exceptional.test( var1, var2, var3, e );
        }
    }

}
