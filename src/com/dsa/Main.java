import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        //findSecondHighestNum(new int[]{10, 15, 20, 50, 40, 30, 70});
       //reverseString("suman kumar");
       // palindromeChecker();
        //oddEvenNumbers();
        removeDuplicates();
 

    }

    public static void oddEvenNumbers(){
        List<Integer> listofNumbers= Arrays.asList(1,2,3,4,5,6,7,8,9,10,11);

        Map<Boolean, List<Integer>> oddEvenSet=listofNumbers.stream().collect(Collectors.partitioningBy(i-> i%2==0));

        for (Map.Entry<Boolean,List<Integer>> entry:oddEvenSet.entrySet()){

            if(entry.getKey()){
                System.out.println("Even Numbers"+entry.getValue());
            }else{
                System.out.println("Odd Numbers"+entry.getValue());
            }
        }
    }
    
    public static void removeDuplicates(){
        List<String> listofElements = Arrays.asList("java","c#","python","kotlin","java");
        List<String> uniqueElements = listofElements.stream().distinct().collect(Collectors.toList());
        System.out.println(uniqueElements);

    }
    
    public static void findSecondHighestNum(int numbers[]){

        int highest = Integer.MIN_VALUE;
        int secondHighest = Integer.MIN_VALUE;

        for(int num: numbers){

            if(num>highest){
                secondHighest = highest;
                highest = num;

            } else if (secondHighest> num) {
                highest = secondHighest;
                secondHighest = num;

            }
        }
        System.out.println("secondHighest Number is:"+secondHighest);

    }

    public static void reverseString(String str){
        String revStr="";
        for(int i=str.length()-1; i>=0; i--){

            revStr =revStr+ str.charAt(i);
        }
        System.out.println("reverseString:"+revStr);
    }

    public static void palindromeChecker(){

        Scanner sc = new Scanner(System.in);
        System.out.println("input String:");
        String inputStr= sc.nextLine();
        String revStr = new StringBuilder(inputStr).reverse().toString();
        if(inputStr.equals(revStr)){
            System.out.println(inputStr+": is palindrome");
        }else{
            System.out.println(inputStr+": is not palindrome");
        }
    }


}