package src.com.dsa;

import java.util.LinkedHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstNonRepeating {

    public static class Main {
        public static void main(String[] args) {
            firstNonRepeatingChar("JavaTJavaDemo");
            char char1 =firstNonRepeating("JavaTJavaDemo");
            System.out.println("first non repeating char is:"+ char1);
        }
    }
    public static void firstNonRepeatingChar(String str){

        for(int i=0; i<str.length();i++){
            if(str.indexOf(str.charAt(i),str.indexOf(str.charAt(i))+1 )==-1){
                System.out.println("First non-repetative char is: "+str.charAt(i));
                break;
            }
        }
    }

    private static char firstNonRepeating(String str){

        Character char1 = str.toUpperCase().chars().mapToObj(c->(char)c)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new,Collectors.counting()))
                .entrySet().stream().filter(entry->entry.getValue()==1L).findFirst().get().getKey();
        return char1;
    }

}

