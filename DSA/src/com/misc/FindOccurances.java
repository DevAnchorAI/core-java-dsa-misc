package com.misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindOccurances {

    public static void findOccurances(String inputStr) {


        Map<Character,Long> occurancesVsCount=inputStr.chars().mapToObj(c->(char)c)
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));

        System.out.println(occurancesVsCount);


    }

    public static void calculateOccurance() {
        String [] strArr = {"suman","kumar","suman","sahani","suman","kumar","kumar"};
        List<String> strList =Arrays.asList(strArr);
        List<String> strList3 = new ArrayList<>();
        Map<String,Long> occourancesCounMap=strList.stream()
                .collect(Collectors.groupingBy(Function.identity(),
                        Collectors.counting()));

        System.out.println(occourancesCounMap);
        for(Map.Entry<String, Long> entry: occourancesCounMap.entrySet()) {

            if(entry.getValue()==3) {
                strList3.add(entry.getKey());
            }
        }
        System.out.println(strList3);
    }


    public static void main(String[] args) {
        String inputStr= "aaabbccde";
        //findOccurances(inputStr);
        calculateOccurance();
    }

}

