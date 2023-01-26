package com.github.rongaru.functional.utility;

import com.github.rongaru.functional.executors.PredicateExecutor;
import com.github.rongaru.functional.executors.SupplierExecutor;
import com.github.rongaru.functional.interfaces.Predicate;
import com.github.rongaru.functional.interfaces.Supplier;

public class PredicateUtility {

    public static < T > boolean evaluate( T arg, Predicate< T > predicate ) {
        return PredicateExecutor.executeOrElseThrow( arg, predicate );
    }

    public static < T > boolean evaluateOnTrueOrElseTrue( boolean condition, T arg, Predicate< T > predicate ) {
        return !condition || PredicateExecutor.executeOrElseThrow( arg, predicate );
    }

    public static < T > boolean evaluateOnTrueOrElseFalse( boolean condition, T arg, Predicate< T > predicate ) {
        return condition && PredicateExecutor.executeOrElseThrow( arg, predicate );
    }

    public static < T > boolean evaluateOnFalseOrElseTrue( boolean condition, T arg, Predicate< T > predicate ) {
        return condition || PredicateExecutor.executeOrElseThrow( arg, predicate );
    }

    public static < T > boolean evaluateOnFalseOrElseFalse( boolean condition, T arg, Predicate< T > predicate ) {
        return !condition && PredicateExecutor.executeOrElseThrow( arg, predicate );
    }

    public static < T > boolean evaluateOnTrueOrElse( boolean condition, T arg, Predicate< T > predicate, boolean value ) {
        return condition ? PredicateExecutor.executeOrElseThrow( arg, predicate ) : value;
    }

    public static < T > boolean evaluateOnFalseOrElse( boolean condition, T arg, Predicate< T > predicate, boolean value ) {
        return condition ? value : PredicateExecutor.executeOrElseThrow( arg, predicate );
    }

    public static < T > boolean evaluateOnTrueOrElse( boolean condition, T arg, Predicate< T > predicate, Supplier< Boolean > supplier ) {
        return condition ? PredicateExecutor.executeOrElseThrow( arg, predicate ) : SupplierExecutor.executeOrElseThrow( supplier );
    }

    public static < T > boolean evaluateOnFalseOrElse( boolean condition, T arg, Predicate< T > predicate, Supplier< Boolean > supplier ) {
        return condition ? SupplierExecutor.executeOrElseThrow( supplier ) : PredicateExecutor.executeOrElseThrow( arg, predicate );
    }

    public static < T > boolean evaluateOnTrueOrElse( boolean condition, T arg, Predicate< T > predicateOnTrue, Predicate< T > predicateOnFalse ) {
        return PredicateExecutor.executeOrElseThrow( arg, condition ? predicateOnTrue : predicateOnFalse );
    }

}
