package com.github.rongaru.functional.wrapper;

import com.github.rongaru.functional.exceptional.*;
import com.github.rongaru.functional.executors.*;

import java.util.function.*;

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

    public static < T, U > BiConsumer< T, U > biConsumer( ExceptionalBiConsumer< T, U > consumer ) {
        return ( var1, var2 ) -> ExceptionalBiConsumerExecutor.execute( var1, var2, consumer );
    }

    public static < T, U > BiPredicate< T, U > biPredicate( ExceptionalBiPredicate< T, U > predicate ) {
        return ( var1, var2 ) -> ExceptionalBiPredicateExecutor.execute( var1, var2, predicate );
    }

    public static < T, U, R > BiFunction< T, U, R > biFunction( ExceptionalBiFunction< T, U, R > function ) {
        return ( var1, var2 ) -> ExceptionalBiFunctionExecutor.execute( var1, var2, function );
    }

}
