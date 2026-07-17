package com.misc;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest {
    public static void main(String[] args) {

//        mapTest();
//        flatMapTest();
      //  countWords();
        //removeDuplicates();
        //findDuplicates();
        //findFirstNonRepeatingChar();
        //mergeTwoListsAndRemoveDuplicates();
        //countChars();
        findLargestDuplicate("abcabcbb");
        //findSecondHighest();
    }



    private static void mapTest(){
        List<String> list = List.of("ram","shayam");
        List<String> str =   list.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println(str);
    }
    private static void flatMapTest(){
        List<List<String>> list = List.of( List.of("A","B"),List.of("C","D"));
       List<String> str =   list.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        System.out.println(str);
    }
    private static void countWords(){
        List<String> words = List.of("java", "spring", "java");
        Map<String,Long> wordsCount =words.stream()
                .collect(  Collectors.groupingBy(Function.identity(),Collectors.counting()));

        System.out.println(wordsCount);
    }

    private static void removeDuplicates(){
        List<Integer> duplist = List.of(1,1,2,2,3,3,4,4,5,5,6,7);
      List<Integer> list =  duplist.stream().distinct().collect(Collectors.toList());
        System.out.println(list);
    }
private static void findDuplicates(){
    List<Integer> duplist = List.of(1,1,2,2,3,3,4,4,5,5,6,7);
    duplist.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
            .forEach((key,value)->{
                if(value>1) System.out.println("duplicate:"+key);
            });

}
    private static void findFirstNonRepeatingChar(){
        String str= "ababcd";
        boolean found = false;
     Map.Entry<Character,Long> char1 =  str.chars().mapToObj(c->(char)c)
                        .collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()))
                        .entrySet().stream()
                        .filter(entry->entry.getValue()==1)
                        .findFirst().get();
        System.out.println(char1.getKey());

    }


    private static void mergeTwoListsAndRemoveDuplicates(){

        List<Integer> list1  = List.of(1,2,3,4,5,6);
        List<Integer> list2  = List.of(6,7,8,9,10,2);
       Stream.concat(list1.stream(),list2.stream()).distinct().forEach(System.out::print);
    }

    private static void countChars(){
        String str = "aabbccdeff";
        str.chars()
                .mapToObj(c->(char)c)
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet().stream().forEach(entry->{
                    System.out.println(entry.getKey()+"::"+entry.getValue());
                });

    }



    private  static void findLargestDuplicate(String str) {
        System.out.println("Input: "+str);
       int n=str.length();
       String longestDup=      IntStream.range(0,n)
                             .boxed()
                                     .flatMap(i-> IntStream.rangeClosed(i+1,n).mapToObj(j->str.substring(i,j)))
                                             .filter(StreamTest::hasUniqueCharacter)
                                                     .max(Comparator.comparingInt(String::length))
                                                             .orElse("");

        System.out.println("longestDup: "+longestDup);
        }

        private static boolean hasUniqueCharacter(String str){

        return  str.chars().distinct().count()==str.length();
        }

        private static void findSecondHighest(){
            int[] numbers = {3, 5, 9, 9, 7, 6};
            System.out.println("Input: "+Arrays.toString(numbers));
           Integer num =  Arrays.stream(numbers).distinct()
                   .boxed()
                   .sorted(Comparator.reverseOrder())
                   .skip(1)
                   .findFirst()
                   .orElse(null);
            System.out.println("2nd highest: "+num);

        }
    }


