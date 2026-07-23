package src.com.misc;

import java.util.Optional;

public class OptionalTest {
    public static void main(String[] args) {
        test();
    }
    private static void test(){

        //Optional<String> optional= Optional.of(null);//throws NPE
        Optional<String> optional = Optional.ofNullable("john");
                if(optional.isPresent()){
            System.out.println(optional.get());
        }
        String str= null;
        String optional1 = Optional.ofNullable(str).orElse("Default");


        System.out.println(optional1);
    }

}
