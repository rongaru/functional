package com.github.rongaru.functional.interfaces;

@FunctionalInterface
public interface BiConsumer< T, U > {

    void accept( T arg1, U arg2 ) throws Throwable;

}
