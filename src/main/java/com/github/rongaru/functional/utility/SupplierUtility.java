package com.github.rongaru.functional.utility;

import java.util.function.Supplier;

public class SupplierUtility {

    public static < T > T getOnTrueOrElse( boolean condition, Supplier< T > supplier ) {
        return condition ? supplier.get( ) : null;
    }

    public static < T > T getOnFalseOrElse( boolean condition, Supplier< T > supplier ) {
        return condition ? null : supplier.get( );
    }

    public static < T > T getOnTrueOrElse( boolean condition, Supplier< T > supplier, T value ) {
        return condition ? supplier.get( ) : value;
    }

    public static < T > T getOnFalseOrElse( boolean condition, Supplier< T > supplier, T value ) {
        return condition ? value : supplier.get( );
    }

    public static < T > T getOnTrueOrElse( boolean condition, Supplier< T > supplierOnTrue, Supplier< T > supplierOnFalse ) {
        return condition ? supplierOnTrue.get( ) : supplierOnFalse.get( );
    }

    public static < T > T getOnFalseOrElse( boolean condition, Supplier< T > supplierOnTrue, Supplier< T > supplierOnFalse ) {
        return condition ? supplierOnFalse.get( ) : supplierOnTrue.get( );
    }

}
