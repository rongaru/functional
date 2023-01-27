package com.github.rongaru.functional.interfaces;

@FunctionalInterface
public interface TriPredicate< T, U, V > {

    boolean test( T var1, U var2, V var3 );

}
