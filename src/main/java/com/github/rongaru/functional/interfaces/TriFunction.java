package com.github.rongaru.functional.interfaces;

@FunctionalInterface
public interface TriFunction< T, U, V, R > {

    R apply( T var1, U var2, V var3 );

}
