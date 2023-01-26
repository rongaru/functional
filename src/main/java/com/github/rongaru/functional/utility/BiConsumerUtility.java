package com.github.rongaru.functional.utility;

import com.github.rongaru.functional.executors.BiConsumerExecutor;
import com.github.rongaru.functional.interfaces.BiConsumer;

import java.util.Arrays;

public class BiConsumerUtility {

    public static < T, U > void accept( T arg1, U arg2, BiConsumer< T, U > consumer ) {
        BiConsumerExecutor.executeOrElseThrow( arg1, arg2, consumer );
    }

    public static < T, U > void acceptOnTrue( boolean condition, T arg1, U arg2, BiConsumer< T, U > consumer ) {
        BiConsumerExecutor.executeOrElseThrow( arg1, arg2, condition ? consumer : ( arg3, arg4 ) -> { } );
    }

    public static < T, U > void acceptOnFalse( boolean condition, T arg1, U arg2, BiConsumer< T, U > consumer ) {
        BiConsumerExecutor.executeOrElseThrow( arg1, arg2, condition ? ( arg3, arg4 ) -> { } : consumer );
    }

    public static < T, U > void acceptMultipleTimes( T arg1, U arg2, BiConsumer< T, U > consumer1, BiConsumer< T, U > consumer2 ) {
        Arrays.asList( consumer1, consumer2 ).forEach( consumer -> BiConsumerExecutor.executeOrElseThrow( arg1, arg2, consumer ) );
    }

    public static < T, U > void acceptOnTrueOrElse( boolean condition, T arg1, U arg2, BiConsumer< T, U > consumerOnTrue, BiConsumer< T, U > consumerOnFalse ) {
        BiConsumerExecutor.executeOrElseThrow( arg1, arg2, condition ? consumerOnTrue : consumerOnFalse );
    }

    public static < T, U > void acceptMultipleTimes( T arg1, U arg2, BiConsumer< T, U > consumer1, BiConsumer< T, U > consumer2, BiConsumer< T, U > consumer3 ) {
        Arrays.asList( consumer1, consumer2, consumer3 ).forEach( consumer -> BiConsumerExecutor.executeOrElseThrow( arg1, arg2, consumer ) );
    }

    public static < T, U > void acceptMultipleTimes( T arg1, U arg2, BiConsumer< T, U > consumer1, BiConsumer< T, U > consumer2, BiConsumer< T, U > consumer3, BiConsumer< T, U > consumer4 ) {
        Arrays.asList( consumer1, consumer2, consumer3, consumer4 ).forEach( consumer -> BiConsumerExecutor.executeOrElseThrow( arg1, arg2, consumer ) );
    }

    public static < T, U > void acceptMultipleTimes( T arg1, U arg2, BiConsumer< T, U > consumer1, BiConsumer< T, U > consumer2, BiConsumer< T, U > consumer3, BiConsumer< T, U > consumer4, BiConsumer< T, U > consumer5 ) {
        Arrays.asList( consumer1, consumer2, consumer3, consumer4, consumer5 ).forEach( consumer -> BiConsumerExecutor.executeOrElseThrow( arg1, arg2, consumer ) );
    }

}
