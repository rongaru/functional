package com.github.rongaru.functional.utility;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerUtility {

    /**
     * @param var T
     */
    public static < T > void accept( T var ) {

    }

    public static < T > void accept( T var, Consumer< T > consumer ) {
        consumer.accept( var );
    }

    /**
     * @param var T
     */
    public static < T > void acceptOnTrue( boolean condition, T var, Consumer< T > consumer ) {
        accept( var, condition ? consumer : ConsumerUtility :: accept );
    }

    public static < T > void acceptOnFalse( boolean condition, T var, Consumer< T > consumer ) {
        accept( var, condition ? ConsumerUtility :: accept : consumer );
    }

    public static < T > void acceptOnTrueOrElse( boolean condition, T var, Consumer< T > consumerOnTrue, Consumer< T > consumerOnFalse ) {
        accept( var, condition ? consumerOnTrue : consumerOnFalse );
    }

    /**
     * @param var T
     */
    public static < T > void acceptForEach( T var, List< Consumer< T > > consumers ) {
        consumers.forEach( consumer -> consumer.accept( var ) );
    }

    public static < T > void acceptForEach( T var, Consumer< T > consumer1, Consumer< T > consumer2 ) {
        acceptForEach( var, Arrays.asList( consumer1, consumer2 ) );
    }

    public static < T > void acceptForEach( T var, Consumer< T > consumer1, Consumer< T > consumer2, Consumer< T > consumer3 ) {
        acceptForEach( var, Arrays.asList( consumer1, consumer2, consumer3 ) );
    }

    public static < T > void acceptForEach( T var, Consumer< T > consumer1, Consumer< T > consumer2, Consumer< T > consumer3, Consumer< T > consumer4 ) {
        acceptForEach( var, Arrays.asList( consumer1, consumer2, consumer3, consumer4 ) );
    }

    public static < T > void acceptForEach( T var, Consumer< T > consumer1, Consumer< T > consumer2, Consumer< T > consumer3, Consumer< T > consumer4, Consumer< T > consumer5 ) {
        acceptForEach( var, Arrays.asList( consumer1, consumer2, consumer3, consumer4, consumer5 ) );
    }

}
