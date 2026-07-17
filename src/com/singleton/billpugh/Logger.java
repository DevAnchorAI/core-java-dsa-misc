package src.com.singleton.billpugh;

public class Logger {

    private Logger(){

    }
    private static class Holder {
        private static final Logger INSTANCE = new Logger();
    }
    public static Logger getInstance() {
        return Holder.INSTANCE;
    }

    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        System.out.println(logger1.hashCode());
        Logger logger2 = Logger.getInstance();
        System.out.println(logger2.hashCode());
        Logger logger3 = Logger.getInstance();
        System.out.println(logger3.hashCode());
    }
}
