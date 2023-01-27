package com.github.rongaru.functional.exceptional;

@FunctionalInterface
public interface ExceptionalConsumer< T > {

    void accept( T var ) throws Throwable;

}
