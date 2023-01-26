package com.github.rongaru.functional.executors;

import com.github.rongaru.functional.interfaces.Function;
import com.github.rongaru.functional.interfaces.Supplier;
import com.github.rongaru.functional.utility.ExceptionUtility;

public class FunctionExecutor {

    public static < T, R > R executeOrElseThrow( T arg, Function< T, R > function ) {
        return executeOrElseApply( arg, function, ExceptionUtility :: throwRuntimeException );
    }

    public static < T, R > R executeOrElsePrintAndGetNull( T arg, Function< T, R > function ) {
        return executeOrElseApply( arg, function, ExceptionUtility :: printStackTraceAndGetNull );
    }

    public static < T, R > R executeOrElsePrintAndGetDefault( T arg, Function< T, R > function, R value ) {
        return executeOrElseApply( arg, function, exception -> ExceptionUtility.printStackTraceAndGetDefault( exception, value ) );
    }

    public static < T, R > R executeOrElsePrintAndGetDefault( T arg, Function< T, R > function, Supplier< R > supplier ) {
        return executeOrElseApply( arg, function, exception -> ExceptionUtility.printStackTraceAndGetDefault( exception, supplier ) );
    }

    public static < T, R > R executeOrElseApply( T arg, Function< T, R > function, Function< Throwable, R > exceptional ) {
        try { return function.apply( arg ); } catch ( Throwable exception ) { return ExceptionUtility.applyException( exception, exceptional ); }
    }

}
