package com.github.rongaru.functional.executors;

import com.github.rongaru.functional.interfaces.Consumer;
import com.github.rongaru.functional.interfaces.Runnable;
import com.github.rongaru.functional.utility.ExceptionUtility;

public class RunnableExecutor {

    public static void executeOrElseThrow( Runnable runnable ) {
        executeOrElseApply( runnable, ExceptionUtility :: throwRuntimeException );
    }

    public static void executeOrElsePrint( Runnable runnable ) {
        executeOrElseApply( runnable, ExceptionUtility :: printStackTraceAndGetNull );
    }

    public static void executeOrElseApply( Runnable runnable, Consumer< Throwable > exceptional ) {
        try { runnable.run( ); } catch ( Throwable exception ) { ExceptionUtility.acceptException( exception, exceptional ); }
    }

}
