package com.github.rongaru.functional.interfaces;

@FunctionalInterface
public interface QuadPredicate< T, U, V, W > {

    boolean test( T var1, U var2, V var3, W var4 );

}
