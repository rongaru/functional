package com.github.rongaru.functional.utility;

import java.util.function.BiFunction;
import java.util.function.Supplier;

public class BiFunctionUtility {

    public static < T, U, R > R apply( T var1, U var2, BiFunction< T, U, R > function ) {
        return function.apply( var1, var2 );
    }

    public static < T, U, R > R applyOnTrue( boolean condition, T var1, U var2, BiFunction< T, U, R > function ) {
        return condition ? function.apply( var1, var2 ) : null;
    }

    public static < T, U, R > R applyOnFalse( boolean condition, T var1, U var2, BiFunction< T, U, R > function ) {
        return condition ? null : function.apply( var1, var2 );
    }

    public static < T, U, R > R applyOnTrueOrElse( boolean condition, T var1, U var2, BiFunction< T, U, R > function, R value ) {
        return condition ? function.apply( var1, var2 ) : value;
    }

    public static < T, U, R > R applyOnFalseOrElse( boolean condition, T var1, U var2, BiFunction< T, U, R > function, R value ) {
        return condition ? value : function.apply( var1, var2 );
    }

    public static < T, U, R > R applyOnTrueOrElseGet( boolean condition, T var1, U var2, BiFunction< T, U, R > function, Supplier< R > supplier ) {
        return condition ? function.apply( var1, var2 ) : supplier.get( );
    }

    public static < T, U, R > R applyOnFalseOrElseGet( boolean condition, T var1, U var2, BiFunction< T, U, R > function, Supplier< R > supplier ) {
        return condition ? supplier.get( ) : function.apply( var1, var2 );
    }

    public static < T, U, R > R applyOnTrueOrElseApply( boolean condition, T var1, U var2, BiFunction< T, U, R > functionOnTrue, BiFunction< T, U, R > functionOnFalse ) {
        return condition ? functionOnTrue.apply( var1, var2 ) : functionOnFalse.apply( var1, var2 );
    }

}
