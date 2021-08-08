// import java.util.ArrayList;
// import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main{

    private static ExecutorService pool;
    //static RandomNumber RNo = new RandomNumber();
    // private  int random;
    // private static ArrayList<Integer> list = new ArrayList<>();
    // private static int sum;
    // private Random r = new Random();


    public static void main(String[] args) throws InterruptedException {

        

        pool = Executors.newFixedThreadPool(5);
        for(int i = 0; i < 5; i++)
            pool.execute(new RandomNumber());
        pool.shutdown();

        pool.awaitTermination(10000000, TimeUnit.NANOSECONDS);

        RandomNumber.getSum();



        
        
    }

    


    
    
}
