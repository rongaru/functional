package com.github.rongaru.functional.exceptional;

@FunctionalInterface
public interface ExceptionalSupplier< T > {

    T get( ) throws Throwable;

}
