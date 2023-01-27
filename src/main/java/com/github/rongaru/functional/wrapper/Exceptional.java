package com.github.rongaru.functional.wrapper;

import com.github.rongaru.functional.exceptional.*;
import com.github.rongaru.functional.executors.*;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Exceptional {

    public static Runnable runnable( ExceptionalRunnable runnable ) {
        return ( ) -> ExceptionalRunnableExecutor.execute( runnable );
    }

    public static < T > Supplier< T > supplier( ExceptionalSupplier< T > supplier ) {
        return ( ) -> ExceptionalSupplierExecutor.execute( supplier );
    }

    public static < T > Consumer< T > consumer( ExceptionalConsumer< T > consumer ) {
        return var -> ExceptionalConsumerExecutor.execute( var, consumer );
    }

    public static < T > Predicate< T > predicate( ExceptionalPredicate< T > predicate ) {
        return var -> ExceptionalPredicateExecutor.execute( var, predicate );
    }

    public static < T, R > Function< T, R > function( ExceptionalFunction< T, R > function ) {
        return var -> ExceptionalFunctionExecutor.execute( var, function );
    }

}
