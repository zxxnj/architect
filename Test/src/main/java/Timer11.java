import java.util.Timer;
import java.util.TimerTask;

public class Timer11 {

    public static volatile int count =0;

    static class TimerTest extends TimerTask {
        @Override
        public void run(){
            count = (count +1 )%2;
            System.out.println(count);
            new Timer().schedule(new TimerTest(),2000 + 2000*count);
        }
    }



    public static void main(String[] args) {
        Timer t = new Timer();
        t.schedule(new TimerTest(),2000 + 2000*count);
    }
}
