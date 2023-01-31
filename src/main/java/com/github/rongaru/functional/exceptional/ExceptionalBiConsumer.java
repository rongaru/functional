package com.github.rongaru.functional.exceptional;

@FunctionalInterface
public interface ExceptionalBiConsumer< T, U > {

    void accept( T var1, U var2 ) throws Throwable;

}
