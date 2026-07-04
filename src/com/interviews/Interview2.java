package src.com.interviews;

import java.util.concurrent.ConcurrentHashMap;

public class Interview2 {

    private static final ConcurrentHashMap<Integer ,String> cache = new ConcurrentHashMap<>();
    public static void main(String[] args) {
        //Reverse words in the String - "My name is Suman Kumar"
//        String str = "My name is Suman Kumar";
//       String  output =  reverseWord(str);
//        System.out.println("output: "+ output);
        Interview2 interview2 = new Interview2();
        interview2.getUserId(1);
        interview2.getUserId(1);

        interview2.computeIfPresent("suman");
    }

    private static String reverseWord(String str) {
        StringBuilder result = new StringBuilder();

        int end=  str.length();
        for (int i = str.length()-1; i >=0; i--) {
           if(str.charAt(i)==' '){
               System.out.println(i+1+","+end);
               result.append(str.substring(i+1,end)).append(" ");
               end=i;
           }
        }

        System.out.println("end: "+end);
        //append the first word
        result.append(str.substring(0,end));
        return result.toString();
    }

  private static String getUserId(Integer id){
      System.out.println("get user with id: "+id);
        return cache.computeIfAbsent(id,Interview2:: getUser);
  }

  private static String getUser(Integer id){
      System.out.println("Fetching from DB...");
      String userId = "User-"+id;
        System.out.println("UserId: "+userId);
        return userId;
  }

ConcurrentHashMap<String,Integer> userLoginCount = new ConcurrentHashMap<>();
  private void computeIfPresent(String userId){
      userLoginCount.put("suman",5);
      userLoginCount.put("raja",2);

        userLoginCount.computeIfPresent(userId, (k,v)->v+1);
      System.out.println(userLoginCount);

  }

}
