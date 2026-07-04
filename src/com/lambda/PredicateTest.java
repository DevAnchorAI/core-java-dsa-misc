package com.lambda;

import java.util.function.Predicate;

public class PredicateTest {
    public static void main(String[] args) {

        Predicate<Integer> greaterThan = i->(i>10);
        Predicate<Integer> lesserThan = i->(i<20);

//        System.out.println(lesserThan.test(10));
//        System.out.println(greaterThan.test(15));
        System.out.println(greaterThan.and(lesserThan).test(15));
        System.out.println(greaterThan.or(lesserThan).test(15));
        System.out.println(greaterThan.and(lesserThan).negate().test(15));
    }

}
