package com.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

//A functional interface has exactly one abstract method.
// Lambda expressions provide its implementation.
@FunctionalInterface
interface FuncInterface {
    int operation(int a,int b);
    default void normalFunction() {
        System.out.println("Normal Function");
    }
}
public class FuncInterfaceImpl {
    public static void main(String[] args) {
        FuncInterface add = (a,b)->a+b;
        FuncInterface multiply = (a,b)->a*b;
        System.out.println(add.operation(5,2));
        System.out.println(multiply.operation(5,2));

    }
}
