package src.com.interviews;


import java.util.concurrent.ConcurrentHashMap;

public class RedisTest {

static ConcurrentHashMap<Integer,String> cache = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        getEmployee(1);
        getEmployee(1);
        getEmployee(1);
    }

    private static void getEmployee(Integer id){
        cache.computeIfAbsent(id,RedisTest::getUser);
    }
    private static String getUser(Integer id){
        System.out.println("getUser: "+id);

        //we can write dB logic
        return "User-"+id;
    }
}
