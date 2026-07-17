package src.com.interviews;

import java.util.LinkedHashMap;
import java.util.Map;


public class InterviewTest {
    public static void main(String[] args) {
        String input = "abcade";
        findFirstNonRepeatingChar(input);
    }

    private static void findFirstNonRepeatingChar(String str){

        int n = str.length();
        java.util.Map<Character,Integer> map = new LinkedHashMap<>();

        for(int i=0; i<n;i++){
            Character ch = str.charAt(i);
            if(map.containsKey(ch)){
                map.put(ch,map.get(ch)+1);
            }else{
                map.put(ch,1);
            }
        }

        for(Map.Entry entry: map.entrySet()){

            int countVal = (Integer)entry.getValue();
            if(countVal==1){
                System.out.println("First non-repeat:"+ entry.getKey());
                break;
            }
        }

    }
}

//EMPLOEE: ID,NAME,SALARY

//select salry
//        from EMPLOYEEE
//                ORDER BY salary desc
//        limit 1,OFFSE 1