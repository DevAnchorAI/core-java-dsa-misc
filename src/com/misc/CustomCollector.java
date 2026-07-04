package com.misc;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;

public class CustomCollector {
    public static void main(String[] args) {
        createCustomCollector();
    }
    //To create Custom Collector in Java 8, use Collector interface and it's 5 core
    //components:supplier,accumulator,combiner,finisher and characteristics
    //This Custom Collector join all string in Upper case.
    public static void createCustomCollector(){
        Collector<String,StringBuilder,String> custumCollector = Collector.of(
             StringBuilder::new,//Constructor //Supplier
                (sb,str)->sb.append(str.toUpperCase()),//Accumulator
                StringBuilder::append,//Combiner
                StringBuilder::toString //Finisher
        );
    List<String> names = Arrays.asList("Suman","Raja","John","Don");
    String result = names.stream().collect(custumCollector);

        System.out.println("result: "+result);

    }
}
