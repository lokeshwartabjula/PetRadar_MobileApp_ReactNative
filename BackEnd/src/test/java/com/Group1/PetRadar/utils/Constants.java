package com.Group1.PetRadar.utils;

public final class Constants {

    private Constants() {
        // private constructor to prevent instantiation
    }
    
    // example constant variables
    public static final String DUMMY_UUID = "0f14d0ab-9605-4a62-a9e4-5ed26688389b";
    public static final Integer DUMMY_INT = 1000;
    public static final Double DUMMY_DOUBLE = 3.141592653589793;
    public static final Float DUMMY_FLOAT = (float) 3.0;
    public static final Long DUMMY_LONG = 3l;
    //44.6344
    public static final String DUMMY_LATITUDE="44.6344";


    
    // example constant methods
    public static final int add(int a, int b) {
        return a + b;
    }
    
    public static final String formatString(String value) {
        return String.format("Value is: %s", value);
    }
}