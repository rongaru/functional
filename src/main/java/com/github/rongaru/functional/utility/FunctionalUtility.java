package com.github.rongaru.functional.utility;

import com.github.rongaru.functional.interfaces.TriConsumer;
import com.github.rongaru.functional.interfaces.TriFunction;

import java.util.function.*;

public class FunctionalUtility {

    /**
     * @param supplier Suppler
     * @param consumer Consumer
     * @implSpec Method allow supplier.
     */
    public static < T > void getThenAccept( Supplier< T > supplier, Consumer< T > consumer ) {
        consumer.accept( supplier.get( ) );
    }

    public static < T, U > U getThenApply( Supplier< T > supplier, Function< T, U > function ) {
        return function.apply( supplier.get( ) );
    }

    public static < T > boolean getThenEvaluate( Supplier< T > supplier, Predicate< T > predicate ) {
        return predicate.test( supplier.get( ) );
    }

    /**
     * @param function Function
     * @param consumer Consumer
     * @implSpec Method allow function.
     */
    public static < T, U > void applyThenAccept( T var, Function< T, U > function, Consumer< U > consumer ) {
        consumer.accept( function.apply( var ) );
    }

    public static < T, U, R > R applyThenApply( T var, Function< T, U > function1, Function< U, R > function2 ) {
        return function2.apply( function1.apply( var ) );
    }

    public static < T, U > boolean applyThenEvaluate( T var, Function< T, U > function, Predicate< U > predicate ) {
        return predicate.test( function.apply( var ) );
    }

    /**
     * @param function BiFunction
     * @param consumer Consumer
     * @implSpec Method allow function.
     */
    public static < T, U, R > void applyThenAccept( T var1, U var2, BiFunction< T, U, R > function, Consumer< R > consumer ) {
        consumer.accept( function.apply( var1, var2 ) );
    }

    public static < T, U, V, R > R applyThenApply( T var1, U var2, BiFunction< T, U, V > function1, Function< V, R > function2 ) {
        return function2.apply( function1.apply( var1, var2 ) );
    }

    public static < T, U, R > boolean applyThenEvaluate( T var1, U var2, BiFunction< T, U, R > function, Predicate< R > predicate ) {
        return predicate.test( function.apply( var1, var2 ) );
    }

    /**
     * @param function TriFunction
     * @param consumer Consumer
     * @implSpec Method allow function.
     */
    public static < T, U, V, R > void applyThenAccept( T var1, U var2, V var3, TriFunction< T, U, V, R > function, Consumer< R > consumer ) {
        consumer.accept( function.apply( var1, var2, var3 ) );
    }

    public static < T, U, V, W, R > R applyThenApply( T var1, U var2, V var3, TriFunction< T, U, V, W > function1, Function< W, R > function2 ) {
        return function2.apply( function1.apply( var1, var2, var3 ) );
    }

    public static < T, U, V, R > boolean applyThenEvaluate( T var1, U var2, V var3, TriFunction< T, U, V, R > function, Predicate< R > predicate ) {
        return predicate.test( function.apply( var1, var2, var3 ) );
    }

    /**
     * @param consumer Consumer
     * @param function TriFunction
     * @implSpec Method allow consumer.
     */
    public static < T, U, V, R > R acceptThenApply( T var1, U var2, V var3, TriConsumer< T, U, V > consumer, TriFunction< T, U, V, R > function ) {
        consumer.accept( var1, var2, var3 );
        return function.apply( var1, var2, var3 );
    }

}
