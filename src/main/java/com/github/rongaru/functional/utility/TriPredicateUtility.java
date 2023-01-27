package com.github.rongaru.functional.utility;

import com.github.rongaru.functional.interfaces.TriPredicate;

import java.util.function.Supplier;

public class TriPredicateUtility {

    public static < T, U, V > boolean evaluate( T var1, U var2, V var3, TriPredicate< T, U, V > predicate ) {
        return predicate.test( var1, var2, var3 );
    }

    public static < T, U, V > boolean evaluateOnTrueOrElseTrue( boolean condition, T var1, U var2, V var3, TriPredicate< T, U, V > predicate ) {
        return !condition || predicate.test( var1, var2, var3 );
    }

    public static < T, U, V > boolean evaluateOnTrueOrElseFalse( boolean condition, T var1, U var2, V var3, TriPredicate< T, U, V > predicate ) {
        return condition && predicate.test( var1, var2, var3 );
    }

    public static < T, U, V > boolean evaluateOnFalseOrElseTrue( boolean condition, T var1, U var2, V var3, TriPredicate< T, U, V > predicate ) {
        return condition || predicate.test( var1, var2, var3 );
    }

    public static < T, U, V > boolean evaluateOnFalseOrElseFalse( boolean condition, T var1, U var2, V var3, TriPredicate< T, U, V > predicate ) {
        return !condition && predicate.test( var1, var2, var3 );
    }

    public static < T, U, V > boolean evaluateOnTrueOrElse( boolean condition, T var1, U var2, V var3, TriPredicate< T, U, V > predicate, boolean value ) {
        return condition ? predicate.test( var1, var2, var3 ) : value;
    }

    public static < T, U, V > boolean evaluateOnFalseOrElse( boolean condition, T var1, U var2, V var3, TriPredicate< T, U, V > predicate, boolean value ) {
        return condition ? value : predicate.test( var1, var2, var3 );
    }

    public static < T, U, V > boolean evaluateOnTrueOrElse( boolean condition, T var1, U var2, V var3, TriPredicate< T, U, V > predicate, Supplier< Boolean > supplier ) {
        return condition ? predicate.test( var1, var2, var3 ) : supplier.get( );
    }

    public static < T, U, V > boolean evaluateOnFalseOrElse( boolean condition, T var1, U var2, V var3, TriPredicate< T, U, V > predicate, Supplier< Boolean > supplier ) {
        return condition ? supplier.get( ) : predicate.test( var1, var2, var3 );
    }

    public static < T, U, V > boolean evaluateOnTrueOrElse( boolean condition, T var1, U var2, V var3, TriPredicate< T, U, V > predicateOnTrue, TriPredicate< T, U, V > predicateOnFalse ) {
        return condition ? predicateOnTrue.test( var1, var2, var3 ) : predicateOnFalse.test( var1, var2, var3 );
    }

}
