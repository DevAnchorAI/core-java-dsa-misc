package src.com.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

//1. accept()
//2. andThen()
public class ConsumerTest {
    public static void main(String[] args) {
        Consumer<List<Integer>> modify = list->{
            for(int i =0;i<list.size();i++){
                list.set(i,list.get(i)*2);
            }
        };
        Consumer<List<Integer>> display = list -> list.stream().forEach(a-> System.out.print(a+" "));

        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(1);
        list.add(4);

        modify.andThen(display).accept(list);

    }
}
