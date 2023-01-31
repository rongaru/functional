package com.github.rongaru.functional.exceptional;

@FunctionalInterface
public interface ExceptionalTriFunction< T, U, V, R > {

    R apply( T var1, U var2, V var3 ) throws Throwable;

}
