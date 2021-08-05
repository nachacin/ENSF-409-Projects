import java.util.Random;

public class RandomNumber implements Runnable {
    private int random;
    private static int sum;

    @Override
    public void run() {
        // TODO Auto-generated method stub
        try{
            Random r = new Random();
            random = r.nextInt(100);
            sum += random;
            System.out.println("This iteration value is: " + random + "\n");
            
            //Thread.sleep(random);


            


        } catch (Exception e) {

        }

        
    }

    public void getSum() {
        System.out.println("The sum is " + sum);
    }


    
    


}