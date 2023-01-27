package com.github.rongaru.functional.utility;

import java.util.function.Predicate;
import java.util.function.Supplier;

public class PredicateUtility {

    public static < T > boolean evaluate( T var, Predicate< T > predicate ) {
        return predicate.test( var );
    }

    public static < T > boolean evaluateOnTrueOrElseTrue( boolean condition, T var, Predicate< T > predicate ) {
        return !condition || predicate.test( var );
    }

    public static < T > boolean evaluateOnTrueOrElseFalse( boolean condition, T var, Predicate< T > predicate ) {
        return condition && predicate.test( var );
    }

    public static < T > boolean evaluateOnFalseOrElseTrue( boolean condition, T var, Predicate< T > predicate ) {
        return condition || predicate.test( var );
    }

    public static < T > boolean evaluateOnFalseOrElseFalse( boolean condition, T var, Predicate< T > predicate ) {
        return !condition && predicate.test( var );
    }

    public static < T > boolean evaluateOnTrueOrElse( boolean condition, T var, Predicate< T > predicate, boolean value ) {
        return condition ? predicate.test( var ) : value;
    }

    public static < T > boolean evaluateOnFalseOrElse( boolean condition, T var, Predicate< T > predicate, boolean value ) {
        return condition ? value : predicate.test( var );
    }

    public static < T > boolean evaluateOnTrueOrElse( boolean condition, T var, Predicate< T > predicate, Supplier< Boolean > supplier ) {
        return condition ? predicate.test( var ) : supplier.get( );
    }

    public static < T > boolean evaluateOnFalseOrElse( boolean condition, T var, Predicate< T > predicate, Supplier< Boolean > supplier ) {
        return condition ? supplier.get( ) : predicate.test( var );
    }

    public static < T > boolean evaluateOnTrueOrElse( boolean condition, T var, Predicate< T > predicateOnTrue, Predicate< T > predicateOnFalse ) {
        return condition ? predicateOnTrue.test( var ) : predicateOnFalse.test( var );
    }

}
