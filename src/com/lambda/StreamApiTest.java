package src.com.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamApiTest {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Suman","Raj","Aarohi","Devid","Alice");
        List<String> filterNames =names.stream() //list to stream conversion
                .filter(name->name.startsWith("A")) //Intermediate: Predicate condition
                .map(String::toUpperCase)//intermediate operation : Function
                .collect(Collectors.toList());//terminal operation

        System.out.println(filterNames);
    }
}
