package com.github.rongaru.functional.utility;

import com.github.rongaru.functional.executors.BiPredicateExecutor;
import com.github.rongaru.functional.executors.SupplierExecutor;
import com.github.rongaru.functional.interfaces.BiPredicate;
import com.github.rongaru.functional.interfaces.Supplier;

public class BiPredicateUtility {

    public static < T, U > boolean evaluate( T arg1, U arg2, BiPredicate< T, U > predicate ) {
        return BiPredicateExecutor.executeOrElseThrow( arg1, arg2, predicate );
    }

    public static < T, U > boolean evaluateOnTrueOrElseTrue( boolean condition, T arg1, U arg2, BiPredicate< T, U > predicate ) {
        return !condition || BiPredicateExecutor.executeOrElseThrow( arg1, arg2, predicate );
    }

    public static < T, U > boolean evaluateOnTrueOrElseFalse( boolean condition, T arg1, U arg2, BiPredicate< T, U > predicate ) {
        return condition && BiPredicateExecutor.executeOrElseThrow( arg1, arg2, predicate );
    }

    public static < T, U > boolean evaluateOnFalseOrElseTrue( boolean condition, T arg1, U arg2, BiPredicate< T, U > predicate ) {
        return condition || BiPredicateExecutor.executeOrElseThrow( arg1, arg2, predicate );
    }

    public static < T, U > boolean evaluateOnFalseOrElseFalse( boolean condition, T arg1, U arg2, BiPredicate< T, U > predicate ) {
        return !condition && BiPredicateExecutor.executeOrElseThrow( arg1, arg2, predicate );
    }

    public static < T, U > boolean evaluateOnTrueOrElse( boolean condition, T arg1, U arg2, BiPredicate< T, U > predicate, boolean value ) {
        return condition ? BiPredicateExecutor.executeOrElseThrow( arg1, arg2, predicate ) : value;
    }

    public static < T, U > boolean evaluateOnFalseOrElse( boolean condition, T arg1, U arg2, BiPredicate< T, U > predicate, boolean value ) {
        return condition ? value : BiPredicateExecutor.executeOrElseThrow( arg1, arg2, predicate );
    }

    public static < T, U > boolean evaluateOnTrueOrElse( boolean condition, T arg1, U arg2, BiPredicate< T, U > predicate, Supplier< Boolean > supplier ) {
        return condition ? BiPredicateExecutor.executeOrElseThrow( arg1, arg2, predicate ) : SupplierExecutor.executeOrElseThrow( supplier );
    }

    public static < T, U > boolean evaluateOnFalseOrElse( boolean condition, T arg1, U arg2, BiPredicate< T, U > predicate, Supplier< Boolean > supplier ) {
        return condition ? SupplierExecutor.executeOrElseThrow( supplier ) : BiPredicateExecutor.executeOrElseThrow( arg1, arg2, predicate );
    }

    public static < T, U > boolean evaluateOnTrueOrElse( boolean condition, T arg1, U arg2, BiPredicate< T, U > predicateOnTrue, BiPredicate< T, U > predicateOnFalse ) {
        return BiPredicateExecutor.executeOrElseThrow( arg1, arg2, condition ? predicateOnTrue : predicateOnFalse );
    }

}
