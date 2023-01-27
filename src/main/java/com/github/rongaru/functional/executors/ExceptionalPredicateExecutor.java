package com.github.rongaru.functional.executors;

import com.github.rongaru.functional.exceptional.ExceptionalPredicate;

import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class ExceptionalPredicateExecutor {

    public static < T > boolean execute( T var, ExceptionalPredicate< T > predicate ) {
        try {
            return predicate.test( var );
        } catch ( Throwable e ) {
            e.printStackTrace( );
            throw new RuntimeException( e );
        }
    }

    public static < T > boolean executeOrElse( T var, ExceptionalPredicate< T > predicate, boolean value ) {
        try {
            return predicate.test( var );
        } catch ( Throwable e ) {
            e.printStackTrace( );
            return value;
        }
    }

    public static < T > boolean executeOrElse( T var, ExceptionalPredicate< T > predicate, Predicate< T > exceptional ) {
        try {
            return predicate.test( var );
        } catch ( Throwable e ) {
            e.printStackTrace( );
            return exceptional.test( var );
        }
    }

    public static < T > boolean executeOrElse( T var, ExceptionalPredicate< T > predicate, Supplier< Boolean > supplier ) {
        try {
            return predicate.test( var );
        } catch ( Throwable e ) {
            e.printStackTrace( );
            return supplier.get( );
        }
    }

    public static < T > boolean executeOrElse( T var, ExceptionalPredicate< T > predicate, BiPredicate< T, Throwable > exceptional ) {
        try {
            return predicate.test( var );
        } catch ( Throwable e ) {
            e.printStackTrace( );
            return exceptional.test( var, e );
        }
    }

}
