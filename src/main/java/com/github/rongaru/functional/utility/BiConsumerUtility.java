package com.github.rongaru.functional.utility;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;

public class BiConsumerUtility {

    /**
     * @param var1 T
     * @param var2 U
     * @implSpec Methods allows consumers.
     */
    public static < T, U > void accept( T var1, U var2 ) {

    }

    public static < T, U > void accept( T var1, U var2, BiConsumer< T, U > consumer ) {
        consumer.accept( var1, var2 );
    }

    /**
     * @param var1 T
     * @param var2 U
     * @implSpec Methods allow conditional consumers.
     */
    public static < T, U > void acceptOnTrue( boolean condition, T var1, U var2, BiConsumer< T, U > consumer ) {
        accept( var1, var2, condition ? consumer : BiConsumerUtility :: accept );
    }

    public static < T, U > void acceptOnFalse( boolean condition, T var1, U var2, BiConsumer< T, U > consumer ) {
        accept( var1, var2, condition ? BiConsumerUtility :: accept : consumer );
    }

    public static < T, U > void acceptOnTrueOrElse( boolean condition, T var1, U var2, BiConsumer< T, U > consumerOnTrue, BiConsumer< T, U > consumerOnFalse ) {
        accept( var1, var2, condition ? consumerOnTrue : consumerOnFalse );
    }

    /**
     * @param var1 T
     * @param var2 U
     * @implSpec Methods allow multiple consumers.
     */
    public static < T, U > void acceptForEach( T var1, U var2, List< BiConsumer< T, U > > consumers ) {
        consumers.forEach( consumer -> consumer.accept( var1, var2 ) );
    }

    public static < T, U > void acceptForEach( T var1, U var2, BiConsumer< T, U > consumer1, BiConsumer< T, U > consumer2 ) {
        acceptForEach( var1, var2, Arrays.asList( consumer1, consumer2 ) );
    }

    public static < T, U > void acceptForEach( T var1, U var2, BiConsumer< T, U > consumer1, BiConsumer< T, U > consumer2, BiConsumer< T, U > consumer3 ) {
        acceptForEach( var1, var2, Arrays.asList( consumer1, consumer2, consumer3 ) );
    }

    public static < T, U > void acceptForEach( T var1, U var2, BiConsumer< T, U > consumer1, BiConsumer< T, U > consumer2, BiConsumer< T, U > consumer3, BiConsumer< T, U > consumer4 ) {
        acceptForEach( var1, var2, Arrays.asList( consumer1, consumer2, consumer3, consumer4 ) );
    }

    public static < T, U > void acceptForEach( T var1, U var2, BiConsumer< T, U > consumer1, BiConsumer< T, U > consumer2, BiConsumer< T, U > consumer3, BiConsumer< T, U > consumer4, BiConsumer< T, U > consumer5 ) {
        acceptForEach( var1, var2, Arrays.asList( consumer1, consumer2, consumer3, consumer4, consumer5 ) );
    }

}
