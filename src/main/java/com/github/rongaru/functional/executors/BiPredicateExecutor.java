package com.github.rongaru.functional.executors;

import com.github.rongaru.functional.interfaces.BiPredicate;
import com.github.rongaru.functional.interfaces.Function;
import com.github.rongaru.functional.interfaces.Supplier;
import com.github.rongaru.functional.utility.ExceptionUtility;

public class BiPredicateExecutor {

    public static < T, U > boolean executeOrElseThrow( T arg1, U arg2, BiPredicate< T, U > predicate ) {
        return executeOrElseApply( arg1, arg2, predicate, ExceptionUtility :: throwRuntimeException );
    }

    public static < T, U > boolean executeOrElsePrintAndGetFalse( T arg1, U arg2, BiPredicate< T, U > predicate ) {
        return executeOrElseApply( arg1, arg2, predicate, exception -> ExceptionUtility.printStackTraceAndGetDefault( exception, false ) );
    }

    public static < T, U > boolean executeOrElsePrintAndGetDefault( T arg1, U arg2, BiPredicate< T, U > predicate, boolean value ) {
        return executeOrElseApply( arg1, arg2, predicate, exception -> ExceptionUtility.printStackTraceAndGetDefault( exception, value ) );
    }

    public static < T, U > boolean executeOrElsePrintAndGetDefault( T arg1, U arg2, BiPredicate< T, U > predicate, Supplier< Boolean > supplier ) {
        return executeOrElseApply( arg1, arg2, predicate, exception -> ExceptionUtility.printStackTraceAndGetDefault( exception, supplier ) );
    }

    public static < T, U > boolean executeOrElseApply( T arg1, U arg2, BiPredicate< T, U > predicate, Function< Throwable, Boolean > exceptional ) {
        try { return predicate.test( arg1, arg2 ); } catch ( Throwable exception ) { return ExceptionUtility.applyException( exception, exceptional ); }
    }

}
