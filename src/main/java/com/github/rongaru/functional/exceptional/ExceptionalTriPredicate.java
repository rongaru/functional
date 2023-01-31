package com.github.rongaru.functional.exceptional;

@FunctionalInterface
public interface ExceptionalTriPredicate< T, U, V > {

    boolean test( T var1, U var2, V var3 ) throws Throwable;

}
