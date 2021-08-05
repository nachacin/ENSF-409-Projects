import java.util.ArrayList;
import java.util.Random;

public class RandomNumber implements Runnable {
<<<<<<< Updated upstream
   // int random;
=======
    private int random;
>>>>>>> Stashed changes
    private static ArrayList<Integer> list = new ArrayList<>();
    private static int sum;
    private Random r;


    @Override
    public void run() {

        
        // TODO Auto-generated method stub
        try{
<<<<<<< Updated upstream
            int random;
            r = new Random();
            //r.setSeed(98769);
            random = r.nextInt(100);
=======
            
            random = r.nextInt(100 - 1) + 1;
>>>>>>> Stashed changes
            addToList(random);
            System.out.println("This iteration value is: " + random + "\n");
            
            //Thread.sleep(random);


            


        } catch (Exception e) {

        }

        
    }

    private void addToList(Integer integer) {
        list.add(integer);

    }


    public void getSum() {
        
        for(int i : list)
        {
            sum += i;
        }

         System.out.println("The sum is: " + sum);
    }


    
    


}