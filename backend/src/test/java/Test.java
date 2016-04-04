import org.joda.time.DateTime;

public class Test {
    public static void main(String[] args){
        int a = 1;
        long result = new DateTime("T17:55:20").getMillisOfDay() - new DateTime().now().getMillisOfDay();
        System.out.println("==============result: " + result);
    }

    public static void abc(int a){
        a++;
    }
}
