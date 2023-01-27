package com.github.rongaru.functional.utility;

import com.github.rongaru.functional.interfaces.TriConsumer;

import java.util.Arrays;
import java.util.List;

public class TriConsumerUtility {

    /**
     * @param var1 T
     * @param var2 U
     * @param var3 V
     * @implSpec Methods allows consumers.
     */
    public static < T, U, V > void accept( T var1, U var2, V var3 ) {

    }

    public static < T, U, V > void accept( T var1, U var2, V var3, TriConsumer< T, U, V > consumer ) {
        consumer.accept( var1, var2, var3 );
    }

    /**
     * @param var1 T
     * @param var2 U
     * @param var3 V
     * @implSpec Methods allow conditional consumers.
     */
    public static < T, U, V > void acceptOnTrue( boolean condition, T var1, U var2, V var3, TriConsumer< T, U, V > consumer ) {
        accept( var1, var2, var3, condition ? consumer : TriConsumerUtility :: accept );
    }

    public static < T, U, V > void acceptOnFalse( boolean condition, T var1, U var2, V var3, TriConsumer< T, U, V > consumer ) {
        accept( var1, var2, var3, condition ? TriConsumerUtility :: accept : consumer );
    }

    public static < T, U, V > void acceptOnTrueOrElse( boolean condition, T var1, U var2, V var3, TriConsumer< T, U, V > consumerOnTrue, TriConsumer< T, U, V > consumerOnFalse ) {
        accept( var1, var2, var3, condition ? consumerOnTrue : consumerOnFalse );
    }

    /**
     * @param var1 T
     * @param var2 U
     * @implSpec Methods allow multiple consumers.
     */
    public static < T, U, V > void acceptForEach( T var1, U var2, V var3, List< TriConsumer< T, U, V > > consumers ) {
        consumers.forEach( consumer -> consumer.accept( var1, var2, var3 ) );
    }

    public static < T, U, V > void acceptForEach( T var1, U var2, V var3, TriConsumer< T, U, V > consumer1, TriConsumer< T, U, V > consumer2 ) {
        acceptForEach( var1, var2, var3, Arrays.asList( consumer1, consumer2 ) );
    }

    public static < T, U, V > void acceptForEach( T var1, U var2, V var3, TriConsumer< T, U, V > consumer1, TriConsumer< T, U, V > consumer2, TriConsumer< T, U, V > consumer3 ) {
        acceptForEach( var1, var2, var3, Arrays.asList( consumer1, consumer2, consumer3 ) );
    }

    public static < T, U, V > void acceptForEach( T var1, U var2, V var3, TriConsumer< T, U, V > consumer1, TriConsumer< T, U, V > consumer2, TriConsumer< T, U, V > consumer3, TriConsumer< T, U, V > consumer4 ) {
        acceptForEach( var1, var2, var3, Arrays.asList( consumer1, consumer2, consumer3, consumer4 ) );
    }

    public static < T, U, V > void acceptForEach( T var1, U var2, V var3, TriConsumer< T, U, V > consumer1, TriConsumer< T, U, V > consumer2, TriConsumer< T, U, V > consumer3, TriConsumer< T, U, V > consumer4, TriConsumer< T, U, V > consumer5 ) {
        acceptForEach( var1, var2, var3, Arrays.asList( consumer1, consumer2, consumer3, consumer4, consumer5 ) );
    }

}
