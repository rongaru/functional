package com.github.rongaru.functional.executors;

import com.github.rongaru.functional.exceptional.ExceptionalBiPredicate;
import com.github.rongaru.functional.interfaces.TriPredicate;

import java.util.function.BiPredicate;
import java.util.function.Supplier;

public class ExceptionalBiPredicateExecutor {

    public static < T, U > boolean execute( T var1, U var2, ExceptionalBiPredicate< T, U > predicate ) {
        try {
            return predicate.test( var1, var2 );
        } catch ( Throwable e ) {
            e.printStackTrace( );
            throw new RuntimeException( e );
        }
    }

    public static < T, U > boolean executeOrElse( T var1, U var2, ExceptionalBiPredicate< T, U > predicate, boolean value ) {
        try {
            return predicate.test( var1, var2 );
        } catch ( Throwable e ) {
            e.printStackTrace( );
            return value;
        }
    }

    public static < T, U > boolean executeOrElse( T var1, U var2, ExceptionalBiPredicate< T, U > predicate, Supplier< Boolean > supplier ) {
        try {
            return predicate.test( var1, var2 );
        } catch ( Throwable e ) {
            e.printStackTrace( );
            return supplier.get( );
        }
    }

    public static < T, U > boolean executeOrElse( T var1, U var2, ExceptionalBiPredicate< T, U > predicate, BiPredicate< T, U > exceptional ) {
        try {
            return predicate.test( var1, var2 );
        } catch ( Throwable e ) {
            e.printStackTrace( );
            return exceptional.test( var1, var2 );
        }
    }

    public static < T, U > boolean executeOrElse( T var1, U var2, ExceptionalBiPredicate< T, U > predicate, TriPredicate< T, U, Throwable > exceptional ) {
        try {
            return predicate.test( var1, var2 );
        } catch ( Throwable e ) {
            e.printStackTrace( );
            return exceptional.test( var1, var2, e );
        }
    }

}
