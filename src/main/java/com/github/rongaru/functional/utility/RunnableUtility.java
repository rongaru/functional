package com.github.rongaru.functional.utility;

public class RunnableUtility {

    public static void run( ) {
    }

    public static void run( Runnable runnable ) {
        runnable.run( );
    }

    public static void runOnTrue( boolean condition, Runnable runnable ) {
        run( condition ? runnable : RunnableUtility :: run );
    }

    public static void runOnFalse( boolean condition, Runnable runnable ) {
        run( condition ? RunnableUtility :: run : runnable );
    }

    public static void runOnTrueOrElse( boolean condition, Runnable runnableOnTrue, Runnable runnableOnFalse ) {
        run( condition ? runnableOnTrue : runnableOnFalse );
    }

}
