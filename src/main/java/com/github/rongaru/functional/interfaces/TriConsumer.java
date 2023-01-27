package com.github.rongaru.functional.interfaces;

@FunctionalInterface
public interface TriConsumer< T, U, V > {

    void accept( T var1, U var2, V var3 );

}
