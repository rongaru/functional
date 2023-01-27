package com.github.rongaru.functional.executors;

import com.github.rongaru.functional.exceptional.ExceptionalSupplier;

import java.util.function.Function;
import java.util.function.Supplier;

public class ExceptionalSupplierExecutor {

    public static < T > T execute( ExceptionalSupplier< T > supplier ) {
        try {
            return supplier.get( );
        } catch ( Throwable e ) {
            e.printStackTrace( );
            throw new RuntimeException( e );
        }
    }

    public static < T > T executeOrElse( ExceptionalSupplier< T > supplier, T value ) {
        try {
            return supplier.get( );
        } catch ( Throwable e ) {
            e.printStackTrace( );
            return value;
        }
    }

    public static < T > T executeOrElse( ExceptionalSupplier< T > supplier, Supplier< T > exceptional ) {
        try {
            return supplier.get( );
        } catch ( Throwable e ) {
            e.printStackTrace( );
            return exceptional.get( );
        }
    }

    public static < T > T executeOrElse( ExceptionalSupplier< T > supplier, Function< Throwable, T > exceptional ) {
        try {
            return supplier.get( );
        } catch ( Throwable e ) {
            e.printStackTrace( );
            return exceptional.apply( e );
        }
    }

}
