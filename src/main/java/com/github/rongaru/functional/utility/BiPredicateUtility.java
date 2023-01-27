package com.github.rongaru.functional.utility;

import java.util.function.BiPredicate;
import java.util.function.Supplier;

public class BiPredicateUtility {

    public static < T, U > boolean evaluate( T var1, U var2, BiPredicate< T, U > predicate ) {
        return predicate.test( var1, var2 );
    }

    public static < T, U > boolean evaluateOnTrueOrElseTrue( boolean condition, T var1, U var2, BiPredicate< T, U > predicate ) {
        return !condition || predicate.test( var1, var2 );
    }

    public static < T, U > boolean evaluateOnTrueOrElseFalse( boolean condition, T var1, U var2, BiPredicate< T, U > predicate ) {
        return condition && predicate.test( var1, var2 );
    }

    public static < T, U > boolean evaluateOnFalseOrElseTrue( boolean condition, T var1, U var2, BiPredicate< T, U > predicate ) {
        return condition || predicate.test( var1, var2 );
    }

    public static < T, U > boolean evaluateOnFalseOrElseFalse( boolean condition, T var1, U var2, BiPredicate< T, U > predicate ) {
        return !condition && predicate.test( var1, var2 );
    }

    public static < T, U > boolean evaluateOnTrueOrElse( boolean condition, T var1, U var2, BiPredicate< T, U > predicate, boolean value ) {
        return condition ? predicate.test( var1, var2 ) : value;
    }

    public static < T, U > boolean evaluateOnFalseOrElse( boolean condition, T var1, U var2, BiPredicate< T, U > predicate, boolean value ) {
        return condition ? value : predicate.test( var1, var2 );
    }

    public static < T, U > boolean evaluateOnTrueOrElse( boolean condition, T var1, U var2, BiPredicate< T, U > predicate, Supplier< Boolean > supplier ) {
        return condition ? predicate.test( var1, var2 ) : supplier.get( );
    }

    public static < T, U > boolean evaluateOnFalseOrElse( boolean condition, T var1, U var2, BiPredicate< T, U > predicate, Supplier< Boolean > supplier ) {
        return condition ? supplier.get( ) : predicate.test( var1, var2 );
    }

    public static < T, U > boolean evaluateOnTrueOrElse( boolean condition, T var1, U var2, BiPredicate< T, U > predicateOnTrue, BiPredicate< T, U > predicateOnFalse ) {
        return condition ? predicateOnTrue.test( var1, var2 ) : predicateOnFalse.test( var1, var2 );
    }

}
