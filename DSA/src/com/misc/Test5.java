package com.misc;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.temporal.TemporalAdjusters;
import java.util.*;

public class Test5 {
    public static void main(String[] args) {
//        StringJoiner sj = new StringJoiner(",", "[", "]");
//        sj.add("A");
//        sj.add("B");
//        sj.add("C");
//        System.out.println(sj);
//
//        printRandomNumbers(10);
//
//        List<Integer> numbers = Arrays.asList(2, 5, 10, 8, 9, 30, 20);
//        highestNumberInList(numbers);
        spliteratorTest();
       LocalDate date = secondFridayOfNextMonth();
        System.out.println("secondFridayOfNextMonth: "+date);

    }

    private static void printRandomNumbers(int n) {
        Random random = new Random();
        random.ints().limit(n).forEach(System.out::println);
    }

    private static void highestNumberInList(List<Integer> numbers) {

        IntSummaryStatistics summaryStatistics = numbers.stream().mapToInt((x) -> x).summaryStatistics();
        System.out.println("MAX:" + summaryStatistics.getMax());
        System.out.println("MIN:" + summaryStatistics.getMin());
    }


    private static LocalDate secondFridayOfNextMonth() {
        LocalDate today = LocalDate.now();
        System.out.println("Today:"+today);
        YearMonth nextMonth = YearMonth.from(today).plusMonths(1);
        LocalDate firstOfNext = nextMonth.atDay(1);
        LocalDate firstFriday = firstOfNext.with(TemporalAdjusters.nextOrSame(DayOfWeek.FRIDAY));
        return firstFriday.plusWeeks(1);
    }

    private static void spliteratorTest(){
        List<String> names= List.of("Suman","Raja","John","Don");
        Spliterator<String> spliterator = names.spliterator();
        spliterator.tryAdvance(System.out::println);
        System.out.println(spliterator.estimateSize());
    }
}

