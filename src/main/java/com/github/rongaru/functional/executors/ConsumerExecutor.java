package com.github.rongaru.functional.executors;

import com.github.rongaru.functional.interfaces.Consumer;
import com.github.rongaru.functional.utility.ExceptionUtility;

public class ConsumerExecutor {

    public static < T > void executeOrElseThrow( T arg, Consumer< T > consumer ) {
        executeOrElseApply( arg, consumer, ExceptionUtility :: throwRuntimeException );
    }

    public static < T > void executeOrElsePrint( T arg, Consumer< T > consumer ) {
        executeOrElseApply( arg, consumer, ExceptionUtility :: printStackTraceAndGetNull );
    }

    public static < T > void executeOrElseApply( T arg, Consumer< T > consumer, Consumer< Throwable > exceptional ) {
        try { consumer.accept( arg ); } catch ( Throwable exception ) { ExceptionUtility.acceptException( exception, exceptional ); }
    }

}
