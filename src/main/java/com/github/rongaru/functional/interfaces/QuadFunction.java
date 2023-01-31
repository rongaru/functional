package com.github.rongaru.functional.interfaces;

@FunctionalInterface
public interface QuadFunction< T, U, V, W, R > {

    R apply( T var1, U var2, V var3, W var4 );

}
