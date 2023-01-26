package com.github.rongaru.functional.interfaces;

@FunctionalInterface
public interface Function< T, R > {

    R apply( T arg ) throws Throwable;

}
