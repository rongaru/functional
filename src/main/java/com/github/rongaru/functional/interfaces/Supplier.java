package com.github.rongaru.functional.interfaces;

@FunctionalInterface
public interface Supplier< T > {

    T get( ) throws Throwable;

}
