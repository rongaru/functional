package com.github.rongaru.functional.interfaces;

@FunctionalInterface
public interface QuadConsumer< T, U, V, W > {

    void accept( T var1, U var2, V var3, W var4 );

}
