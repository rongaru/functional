package com.github.rongaru.functional.executors;

import com.github.rongaru.functional.exceptional.ExceptionalTriConsumer;
import com.github.rongaru.functional.interfaces.QuadConsumer;
import com.github.rongaru.functional.interfaces.TriConsumer;

public class ExceptionalTriConsumerExecutor {

    public static < T, U, V > void execute( T var1, U var2, V var3, ExceptionalTriConsumer< T, U, V > consumer ) {
        try {
            consumer.accept( var1, var2, var3 );
        } catch ( Throwable e ) {
            e.printStackTrace( );
            throw new RuntimeException( e );
        }
    }

    public static < T, U, V > void executeOrElse( T var1, U var2, V var3, ExceptionalTriConsumer< T, U, V > consumer, TriConsumer< T, U, V > exceptional ) {
        try {
            consumer.accept( var1, var2, var3 );
        } catch ( Throwable e ) {
            e.printStackTrace( );
            exceptional.accept( var1, var2, var3 );
        }
    }

    public static < T, U, V > void executeOrElse( T var1, U var2, V var3, ExceptionalTriConsumer< T, U, V > consumer, QuadConsumer< T, U, V, Throwable > exceptional ) {
        try {
            consumer.accept( var1, var2, var3 );
        } catch ( Throwable e ) {
            e.printStackTrace( );
            exceptional.accept( var1, var2, var3, e );
        }
    }

}
