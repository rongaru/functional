package com.github.rongaru.functional.utility;

import com.github.rongaru.functional.interfaces.TriFunction;

import java.util.function.Supplier;

public class TriFunctionUtility {

    public static < T, U, V, R > R apply( T var1, U var2, V var3, TriFunction< T, U, V, R > function ) {
        return function.apply( var1, var2, var3 );
    }

    public static < T, U, V, R > R applyOnTrue( boolean condition, T var1, U var2, V var3, TriFunction< T, U, V, R > function ) {
        return condition ? function.apply( var1, var2, var3 ) : null;
    }

    public static < T, U, V, R > R applyOnFalse( boolean condition, T var1, U var2, V var3, TriFunction< T, U, V, R > function ) {
        return condition ? null : function.apply( var1, var2, var3 );
    }

    public static < T, U, V, R > R applyOnTrueOrElse( boolean condition, T var1, U var2, V var3, TriFunction< T, U, V, R > function, R value ) {
        return condition ? function.apply( var1, var2, var3 ) : value;
    }

    public static < T, U, V, R > R applyOnFalseOrElse( boolean condition, T var1, U var2, V var3, TriFunction< T, U, V, R > function, R value ) {
        return condition ? value : function.apply( var1, var2, var3 );
    }

    public static < T, U, V, R > R applyOnTrueOrElseGet( boolean condition, T var1, U var2, V var3, TriFunction< T, U, V, R > function, Supplier< R > supplier ) {
        return condition ? function.apply( var1, var2, var3 ) : supplier.get( );
    }

    public static < T, U, V, R > R applyOnFalseOrElseGet( boolean condition, T var1, U var2, V var3, TriFunction< T, U, V, R > function, Supplier< R > supplier ) {
        return condition ? supplier.get( ) : function.apply( var1, var2, var3 );
    }

    public static < T, U, V, R > R applyOnTrueOrElseApply( boolean condition, T var1, U var2, V var3, TriFunction< T, U, V, R > functionOnTrue, TriFunction< T, U, V, R > functionOnFalse ) {
        return condition ? functionOnTrue.apply( var1, var2, var3 ) : functionOnFalse.apply( var1, var2, var3 );
    }

}
