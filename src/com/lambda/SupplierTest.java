package com.lambda;

import java.util.function.Supplier;

public class SupplierTest {
    public static void main(String[] args) {
        //Example of Supplier<T>
        //take no arguments but supplies result of type T
        Supplier<Double> randomNums = ()-> Math.random();
        System.out.println(randomNums.get());
    }
}
