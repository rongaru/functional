package com.github.rongaru.functional.exceptional;

@FunctionalInterface
public interface ExceptionalBiFunction< T, U, R > {

    R apply( T var1, U var2 ) throws Throwable;

}
