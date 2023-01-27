package com.github.rongaru.functional.exceptional;

@FunctionalInterface
public interface ExceptionalFunction< T, R > {

    R apply( T var ) throws Throwable;

}
