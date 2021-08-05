
public class Main {

    public static void main(String[] args) throws InterruptedException {

        RandomNumber r1 = new RandomNumber();
        RandomNumber r2 = new RandomNumber();
        RandomNumber r3 = new RandomNumber();
        RandomNumber r4 = new RandomNumber();
        RandomNumber r5 = new RandomNumber();
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        Thread t3 = new Thread(r3);
        Thread t4 = new Thread(r4);
        Thread t5 = new Thread(r5);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();


        t1.join();
        t2.join();
        t3.join();
        t4.join();
        t5.join();





        
        r5.getSum();

        
    }
    
}
