package com.github.rongaru.functional.executors;

import com.github.rongaru.functional.interfaces.BiFunction;
import com.github.rongaru.functional.interfaces.Function;
import com.github.rongaru.functional.interfaces.Supplier;
import com.github.rongaru.functional.utility.ExceptionUtility;

public class BiFunctionExecutor {

    public static < T, U, R > R executeOrElseThrow( T arg1, U arg2, BiFunction< T, U, R > function ) {
        return executeOrElseApply( arg1, arg2, function, ExceptionUtility :: throwRuntimeException );
    }

    public static < T, U, R > R executeOrElsePrintAndGetNull( T arg1, U arg2, BiFunction< T, U, R > function ) {
        return executeOrElseApply( arg1, arg2, function, ExceptionUtility :: printStackTraceAndGetNull );
    }

    public static < T, U, R > R executeOrElsePrintAndGetDefault( T arg1, U arg2, BiFunction< T, U, R > function, R value ) {
        return executeOrElseApply( arg1, arg2, function, exception -> ExceptionUtility.printStackTraceAndGetDefault( exception, value ) );
    }

    public static < T, U, R > R executeOrElsePrintAndGetDefault( T arg1, U arg2, BiFunction< T, U, R > function, Supplier< R > supplier ) {
        return executeOrElseApply( arg1, arg2, function, exception -> ExceptionUtility.printStackTraceAndGetDefault( exception, supplier ) );
    }

    public static < T, U, R > R executeOrElseApply( T arg1, U arg2, BiFunction< T, U, R > function, Function< Throwable, R > exceptional ) {
        try { return function.apply( arg1, arg2 ); } catch ( Throwable throwable ) { return ExceptionUtility.applyException( throwable, exceptional ); }
    }

}
