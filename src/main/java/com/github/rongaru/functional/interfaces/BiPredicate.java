package com.github.rongaru.functional.interfaces;

@FunctionalInterface
public interface BiPredicate< T, U > {

    boolean test( T arg1, U arg2 ) throws Exception;

}
