package src.com.singleton.locking;

public class Logger {
    private static volatile Logger instance = null;
    private Logger(){

    }

    public static Logger getInstance(){
        if(instance ==null){
            synchronized (Logger.class){
                if(instance == null){
                    return instance =   new Logger();
                }

            }
        }
        return instance;
    }

    public static void main(String[] args) {

        Logger logger1 = Logger.getInstance();
        System.out.println(logger1.hashCode());
        Logger logger2 = Logger.getInstance();
        System.out.println(logger2.hashCode());
    }
}
