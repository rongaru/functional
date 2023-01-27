package com.github.rongaru.functional.exceptional;

@FunctionalInterface
public interface ExceptionalPredicate< T > {

    boolean test( T var ) throws Throwable;

}
