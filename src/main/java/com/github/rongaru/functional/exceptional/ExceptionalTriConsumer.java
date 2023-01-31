package com.github.rongaru.functional.exceptional;

@FunctionalInterface
public interface ExceptionalTriConsumer< T, U, V > {

    void accept( T var1, U var2, V var3 ) throws Throwable;

}
