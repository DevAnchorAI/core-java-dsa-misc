package src.com.interviews;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Interview1 {
    public static void main(String[] args) {
        String input= "hello java world";
        concatWordAndMakeFirstCharUpper(input);
    }

    private static String concatWordAndMakeFirstCharUpper(String input){
        System.out.println("Input: "+input);
        String streamStr = "#"+ Arrays.stream(input.split("\\s+"))
                .map(str->String.valueOf(str.charAt(0)).toUpperCase()+ str.substring(1))
                .collect(Collectors.joining());

        System.out.println("Output: "+streamStr);
        return streamStr;
    }
}
