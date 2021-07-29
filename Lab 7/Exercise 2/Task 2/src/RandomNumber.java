import java.util.ArrayList;
import java.util.Random;

public class RandomNumber implements Runnable {
    private  int random;
    private static ArrayList<Integer> list = new ArrayList<>();
    private static int sum;
    private Random r = new Random();

    @Override
    public void run() {

        
        // TODO Auto-generated method stub
        try{
            
            random = r.nextInt(100);
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