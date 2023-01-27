package com.github.rongaru.functional.utility;

import java.util.function.Function;
import java.util.function.Supplier;

public class FunctionUtility {

    /**
     * @param var T
     * @return Type R
     * @implSpec Methods allows functions.
     */
    public static < T, R > R apply( T var, Function< T, R > function ) {
        return function.apply( var );
    }

    /**
     * @param var T
     * @return Type R
     * @implSpec Methods allows conditional functions.
     */
    public static < T, R > R applyOnTrue( boolean condition, T var, Function< T, R > function ) {
        return condition ? function.apply( var ) : null;
    }

    public static < T, R > R applyOnFalse( boolean condition, T var, Function< T, R > function ) {
        return condition ? null : function.apply( var );
    }

    public static < T, R > R applyOnTrueOrElse( boolean condition, T var, Function< T, R > function, R value ) {
        return condition ? function.apply( var ) : value;
    }

    public static < T, R > R applyOnFalseOrElse( boolean condition, T var, Function< T, R > function, R value ) {
        return condition ? value : function.apply( var );
    }

    public static < T, R > R applyOnTrueOrElseGet( boolean condition, T var, Function< T, R > function, Supplier< R > supplier ) {
        return condition ? function.apply( var ) : supplier.get( );
    }

    public static < T, R > R applyOnFalseOrElseGet( boolean condition, T var, Function< T, R > function, Supplier< R > supplier ) {
        return condition ? supplier.get( ) : function.apply( var );
    }

    public static < T, R > R applyOnTrueOrElseApply( boolean condition, T var, Function< T, R > functionOnTrue, Function< T, R > functionOnFalse ) {
        return condition ? functionOnTrue.apply( var ) : functionOnFalse.apply( var );
    }

    /**
     * @param var T
     * @return Type R
     * @implSpec Methods allows multiple functions.
     */
    public static < T, U, R > R applyMultipleTimes( T var, Function< T, U > function1, Function< U, R > function2 ) {
        return function2.apply( function1.apply( var ) );
    }

    public static < T, U, V, R > R applyMultipleTimes( T var, Function< T, U > function1, Function< U, V > function2, Function< V, R > function3 ) {
        return function3.apply( function2.apply( function1.apply( var ) ) );
    }

    public static < T, U, V, W, R > R applyMultipleTimes( T var, Function< T, U > function1, Function< U, V > function2, Function< V, W > function3, Function< W, R > function4 ) {
        return function4.apply( function3.apply( function2.apply( function1.apply( var ) ) ) );
    }

    public static < T, U, V, W, X, R > R applyMultipleTimes( T var, Function< T, U > function1, Function< U, V > function2, Function< V, W > function3, Function< W, X > function4, Function< X, R > function5 ) {
        return function5.apply( function4.apply( function3.apply( function2.apply( function1.apply( var ) ) ) ) );
    }

}
