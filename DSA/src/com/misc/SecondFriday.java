package com.misc;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Utility to compute the second Friday of the next month.
 */
public class SecondFriday {

    /**
     * Returns the date of the second Friday of the month after the month that contains the given date.
     * Example: if date is 2026-01-31, this returns the second Friday of February 2026.
     *
     * Algorithm:
     * - Move to the first day of next month.
     * - Find the first Friday on/after that day.
     * - Add 1 week to get the second Friday.
     *
     * @param date base date
     * @return LocalDate of the second Friday of next month
     */
    public static LocalDate secondFridayOfNextMonth(LocalDate date) {
        LocalDate firstOfNext = date.withDayOfMonth(1).plusMonths(1);
        int target = DayOfWeek.FRIDAY.getValue(); // 5
        int firstDow = firstOfNext.getDayOfWeek().getValue();
        int daysToFirstFriday = (target - firstDow + 7) % 7;
        LocalDate firstFriday = firstOfNext.plusDays(daysToFirstFriday);
        return firstFriday.plusWeeks(1);
    }

    public static void main(String[] args) {
        DateTimeFormatter fmt = DateTimeFormatter.ISO_LOCAL_DATE;

        // Demonstrate with today's date
        LocalDate today = LocalDate.now();
        System.out.println("Today: " + today.format(fmt));
        System.out.println("Second Friday of next month: " + secondFridayOfNextMonth(today).format(fmt));

        // A few explicit examples (edge cases)
        LocalDate example1 = LocalDate.of(2026, 1, 31); // provided context date
        System.out.println("Example (2026-01-31) -> " + secondFridayOfNextMonth(example1).format(fmt));

        LocalDate example2 = LocalDate.of(2026, 2, 1); // next month is March 2026
        System.out.println("Example (2026-02-01) -> " + secondFridayOfNextMonth(example2).format(fmt));

        LocalDate example3 = LocalDate.of(2024, 8, 30); // next month Sept 2024
        System.out.println("Example (2024-08-30) -> " + secondFridayOfNextMonth(example3).format(fmt));
    }
}

