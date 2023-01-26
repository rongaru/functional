package com.github.rongaru.functional.executors;

import com.github.rongaru.functional.interfaces.Function;
import com.github.rongaru.functional.interfaces.Supplier;
import com.github.rongaru.functional.interfaces.TriFunction;
import com.github.rongaru.functional.utility.ExceptionUtility;

public class TriFunctionExecutor {

    public static < T, U, V, R > R executeOrElseThrow( T arg1, U arg2, V arg3, TriFunction< T, U, V, R > function ) {
        return executeOrElseApply( arg1, arg2, arg3, function, ExceptionUtility :: throwRuntimeException );
    }

    public static < T, U, V, R > R executeOrElsePrintAndGetNull( T arg1, U arg2, V arg3, TriFunction< T, U, V, R > function ) {
        return executeOrElseApply( arg1, arg2, arg3, function, ExceptionUtility :: printStackTraceAndGetNull );
    }

    public static < T, U, V, R > R executeOrElsePrintAndGetDefault( T arg1, U arg2, V arg3, TriFunction< T, U, V, R > function, R value ) {
        return executeOrElseApply( arg1, arg2, arg3, function, exception -> ExceptionUtility.printStackTraceAndGetDefault( exception, value ) );
    }

    public static < T, U, V, R > R executeOrElsePrintAndGetDefault( T arg1, U arg2, V arg3, TriFunction< T, U, V, R > function, Supplier< R > supplier ) {
        return executeOrElseApply( arg1, arg2, arg3, function, exception -> ExceptionUtility.printStackTraceAndGetDefault( exception, supplier ) );
    }

    public static < T, U, V, R > R executeOrElseApply( T arg1, U arg2, V arg3, TriFunction< T, U, V, R > function, Function< Throwable, R > exceptional ) {
        try { return function.apply( arg1, arg2, arg3 ); } catch ( Throwable exception ) { return ExceptionUtility.applyException( exception, exceptional ); }
    }

}
