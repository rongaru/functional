package com.github.rongaru.functional.executors;

import com.github.rongaru.functional.interfaces.Function;
import com.github.rongaru.functional.interfaces.Predicate;
import com.github.rongaru.functional.interfaces.Supplier;
import com.github.rongaru.functional.utility.ExceptionUtility;

public class PredicateExecutor {

    public static < T > boolean executeOrElseThrow( T arg, Predicate< T > predicate ) {
        return executeOrElseApply( arg, predicate, ExceptionUtility :: throwRuntimeException );
    }

    public static < T > boolean executeOrElsePrintAndGetFalse( T arg, Predicate< T > predicate ) {
        return executeOrElseApply( arg, predicate, exception -> ExceptionUtility.printStackTraceAndGetDefault( exception, false ) );
    }

    public static < T > boolean executeOrElsePrintAndGetDefault( T arg, Predicate< T > predicate, boolean value ) {
        return executeOrElseApply( arg, predicate, exception -> ExceptionUtility.printStackTraceAndGetDefault( exception, value ) );
    }

    public static < T > boolean executeOrElsePrintAndGetDefault( T arg, Predicate< T > predicate, Supplier< Boolean > supplier ) {
        return executeOrElseApply( arg, predicate, exception -> ExceptionUtility.printStackTraceAndGetDefault( exception, supplier ) );
    }

    public static < T > boolean executeOrElseApply( T arg, Predicate< T > predicate, Function< Throwable, Boolean > exceptional ) {
        try { return predicate.test( arg ); } catch ( Throwable exception ) { return ExceptionUtility.applyException( exception, exceptional ); }
    }

}
