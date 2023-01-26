package com.github.rongaru.functional.utility;

import com.github.rongaru.functional.executors.SupplierExecutor;
import com.github.rongaru.functional.interfaces.Supplier;

public class SupplierUtility {

    public static < T > T getOnTrueOrElse( boolean condition, Supplier< T > supplier ) {
        return condition ? SupplierExecutor.executeOrElseThrow( supplier ) : null;
    }

    public static < T > T getOnFalseOrElse( boolean condition, Supplier< T > supplier ) {
        return condition ? null : SupplierExecutor.executeOrElseThrow( supplier );
    }

    public static < T > T getOnTrueOrElse( boolean condition, Supplier< T > supplier, T value ) {
        return condition ? SupplierExecutor.executeOrElseThrow( supplier ) : value;
    }

    public static < T > T getOnFalseOrElse( boolean condition, Supplier< T > supplier, T value ) {
        return condition ? value : SupplierExecutor.executeOrElseThrow( supplier );
    }

    public static < T > T getOnTrueOrElse( boolean condition, Supplier< T > supplier, Supplier< T > supplier2 ) {
        return SupplierExecutor.executeOrElseThrow( condition ? supplier : supplier2 );
    }

    public static < T > T getOnFalseOrElse( boolean condition, Supplier< T > supplier, Supplier< T > supplier2 ) {
        return SupplierExecutor.executeOrElseThrow( condition ? supplier2 : supplier );
    }

}
