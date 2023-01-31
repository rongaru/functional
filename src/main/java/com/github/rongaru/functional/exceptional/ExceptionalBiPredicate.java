package com.github.rongaru.functional.exceptional;

@FunctionalInterface
public interface ExceptionalBiPredicate< T, U > {

    boolean test( T var1, U var2 ) throws Throwable;

}
