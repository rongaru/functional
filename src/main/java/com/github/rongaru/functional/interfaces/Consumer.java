package com.github.rongaru.functional.interfaces;

@FunctionalInterface
public interface Consumer< T > {

    void accept( T arg ) throws Throwable;

}
