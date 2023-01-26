package com.github.rongaru.functional.executors;

import com.github.rongaru.functional.interfaces.BiConsumer;
import com.github.rongaru.functional.interfaces.Consumer;
import com.github.rongaru.functional.utility.ExceptionUtility;

public class BiConsumerExecutor {

    public static < T, U > void executeOrElseThrow( T arg1, U arg2, BiConsumer< T, U > consumer ) {
        executeOrElseApply( arg1, arg2, consumer, ExceptionUtility :: throwRuntimeException );
    }

    public static < T, U > void executeOrElsePrint( T arg1, U arg2, BiConsumer< T, U > consumer ) {
        executeOrElseApply( arg1, arg2, consumer, ExceptionUtility :: printStackTraceAndGetNull );
    }

    public static < T, U > void executeOrElseApply( T arg1, U arg2, BiConsumer< T, U > consumer, Consumer< Throwable > exceptional ) {
        try { consumer.accept( arg1, arg2 ); } catch ( Throwable throwable ) { ExceptionUtility.acceptException( throwable, exceptional ); }
    }

}
