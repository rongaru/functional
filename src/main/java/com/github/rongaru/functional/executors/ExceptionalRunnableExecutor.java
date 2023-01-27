package com.github.rongaru.functional.executors;

import com.github.rongaru.functional.exceptional.ExceptionalRunnable;

import java.util.function.Consumer;

public class ExceptionalRunnableExecutor {

    public static void execute( ExceptionalRunnable runnable ) {
        try {
            runnable.run( );
        } catch ( Throwable e ) {
            e.printStackTrace( );
            throw new RuntimeException( e );
        }
    }

    public static void executeOrElse( ExceptionalRunnable runnable, Runnable exceptional ) {
        try {
            runnable.run( );
        } catch ( Throwable e ) {
            e.printStackTrace( );
            exceptional.run( );
        }
    }

    public static void executeOrElse( Runnable runnable, Consumer< Throwable > exceptional ) {
        try {
            runnable.run( );
        } catch ( Throwable e ) {
            e.printStackTrace( );
            exceptional.accept( e );
        }
    }

}
