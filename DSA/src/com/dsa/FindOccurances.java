package DSA.src.com.dsa;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindOccurances {

    public static void main(String[] args) {
        String inputStr= "aaabbccde";
        findCharOccurances(inputStr);
        String [] strArr = {"suman","kumar","suman","sahani","kumar","kumar"};
        findStringOccurance(strArr);
    }

    public static void findCharOccurances(String str){

    Map<Character,Long> charVsCount = str.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
    System.out.println(charVsCount);
    }

    public static void  findStringOccurance(String[] arr){

       Map<String, Long> stringVsCount = Arrays.stream(arr).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println(stringVsCount);
        stringVsCount.forEach((s, aLong) ->{
            if (aLong>=3) System.out.println(s);
        });
    }

}

