package com.github.rongaru.functional.executors;

import com.github.rongaru.functional.exceptional.ExceptionalBiConsumer;
import com.github.rongaru.functional.interfaces.TriConsumer;

import java.util.function.BiConsumer;

public class ExceptionalBiConsumerExecutor {

    public static < T, U > void execute( T var1, U var2, ExceptionalBiConsumer< T, U > consumer ) {
        try {
            consumer.accept( var1, var2 );
        } catch ( Throwable e ) {
            e.printStackTrace( );
            throw new RuntimeException( e );
        }
    }

    public static < T, U > void executeOrElse( T var1, U var2, ExceptionalBiConsumer< T, U > consumer, BiConsumer< T, U > exceptional ) {
        try {
            consumer.accept( var1, var2 );
        } catch ( Throwable e ) {
            e.printStackTrace( );
            exceptional.accept( var1, var2 );
        }
    }

    public static < T, U > void executeOrElse( T var1, U var2, ExceptionalBiConsumer< T, U > consumer, TriConsumer< T, U, Throwable > exceptional ) {
        try {
            consumer.accept( var1, var2 );
        } catch ( Throwable e ) {
            e.printStackTrace( );
            exceptional.accept( var1, var2, e );
        }
    }

}
