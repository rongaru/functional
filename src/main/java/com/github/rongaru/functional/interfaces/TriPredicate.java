package com.github.rongaru.functional.interfaces;

@FunctionalInterface
public interface TriPredicate< T, U, V > {

    boolean test( T arg1, U arg2, V arg3 ) throws Throwable;

}
