package com.github.rongaru.functional.interfaces;

@FunctionalInterface
public interface Predicate< T > {

    boolean test( T arg ) throws Exception;

}
