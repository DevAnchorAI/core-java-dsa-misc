package com.misc;

import java.util.LinkedHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstNonRepeating {

    public static void FirstNonRepeat(String s)
    {

        for (int i = 0; i < s.length(); i++) {


            if (s.indexOf(s.charAt(i), s.indexOf(s.charAt(i)) + 1) == -1) {
                System.out.println("First non-repeating character is "+ s.charAt(i));
                break;
            }
        }
        return;
    }

    private static Character logic(String input) {
        Character char1 =input.chars().mapToObj(i-> Character.toLowerCase((char)i) )
                .collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()))
                .entrySet().stream().filter(entry-> entry.getValue()== 1L)
                .map(entry->entry.getKey()).findFirst().get();
        return char1;

    }
    public static class Main {
        public static void main(String[] args) {
            FirstNonRepeat("JavaTJavaDemo");
            Character char1 =logic("JavaTJavaDemo");
            System.out.println("first non repeating char is:"+char1);
        }
    }
}

