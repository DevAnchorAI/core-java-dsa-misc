package src.com.java8;

public class FuncInterfaceTest {
    public static void main(String[] args) {
        System.out.println("FuncInterfaceTest");
        Calculator calculator = (a,b)-> a+b;
        int result = calculator.calc(10,5);
        System.out.println("sum:"+result);

        Calculator calculator1 = (a,b)-> a*b;
       int result1= calculator1.calc(10,5);
        System.out.println("multiply:"+result1);

        Calculator calculator2= (a,b)-> a-b;
        int result2 = calculator2.calc(10,5);
        System.out.println("substract:"+result2);

        Calculator calculator3= (a,b)-> a/b;
        int result3 = calculator3.calc(10,5);
        System.out.println("substract:"+result3);
    }
}

@FunctionalInterface
interface Calculator{
    int calc(int a, int b);
}