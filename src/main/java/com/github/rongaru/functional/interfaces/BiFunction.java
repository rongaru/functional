package com.github.rongaru.functional.interfaces;

@FunctionalInterface
public interface BiFunction< T, U, R > {

    R apply( T arg1, U arg2 ) throws Throwable;

}
