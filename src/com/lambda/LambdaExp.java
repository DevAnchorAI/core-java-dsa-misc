package src.com.lambda;

import java.util.Arrays;
import java.util.List;

public class LambdaExp {
    public static void main(String[] args) {
        List<String> fruits = Arrays.asList("Mango","Grapes","Apple","Bananas","papaya");
        fruits.forEach(n-> System.out.println(n));
        System.out.println("\n Starting with A\n");

        //Common Built-in Function interface
        fruits.stream()
                .filter(name-> name.startsWith("A")) //Predicate<T>: Tests a given condition and returns true or false.
                .map(name->name.toUpperCase()) //Function<T,R>:take 1 argument of type T and return results of type R
                .forEach(System.out::println);//Consumer<T>: take 1 argument and return no result

    }
}
