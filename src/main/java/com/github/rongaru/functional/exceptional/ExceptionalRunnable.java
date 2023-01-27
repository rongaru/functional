package com.github.rongaru.functional.exceptional;

@FunctionalInterface
public interface ExceptionalRunnable {

    void run( ) throws Throwable;

}
