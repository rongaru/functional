package com.github.rongaru.functional.executors;

import com.github.rongaru.functional.exceptional.ExceptionalConsumer;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ExceptionalConsumerExecutor {

    public static < T > void execute( T var, ExceptionalConsumer< T > consumer ) {
        try {
            consumer.accept( var );
        } catch ( Throwable e ) {
            e.printStackTrace( );
            throw new RuntimeException( e );
        }
    }

    public static < T > void executeOrElse( T var, ExceptionalConsumer< T > consumer, Consumer< T > exceptional ) {
        try {
            consumer.accept( var );
        } catch ( Throwable e ) {
            e.printStackTrace( );
            exceptional.accept( var );
        }
    }

    public static < T > void executeOrElse( T var, ExceptionalConsumer< T > consumer, BiConsumer< T, Throwable > exceptional ) {
        try {
            consumer.accept( var );
        } catch ( Throwable e ) {
            e.printStackTrace( );
            exceptional.accept( var, e );
        }
    }

}
