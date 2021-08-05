import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main implements Runnable {

    private static ExecutorService pool;

    public static void main(String[] args) throws InterruptedException {

        

        pool = Executors.newFixedThreadPool(5);
        pool.submit(new RandomNumber());
        pool.submit(new RandomNumber());
        pool.submit(new RandomNumber());
        pool.submit(new RandomNumber());
        pool.submit(new RandomNumber());
        
        
        // Thread t1 = new Thread(r1);
        // Thread t2 = new Thread(r2);
        // Thread t3 = new Thread(r3);
        // Thread t4 = new Thread(r4);
        // Thread t5 = new Thread(r5);

        // t1.start();
        // t2.start();
        // t3.start();
        // t4.start();
        // t5.start();
        // t1.join();
        // t2.join();
        // t3.join();
        // t4.join();
        // t5.join();
        pool.wait();

        RandomNumber.getSum();

        
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        
        
    }

    
    
}
