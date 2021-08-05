import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class RunnableResource implements Runnable {
    
	int counter;
	private Lock counterLock;

	public RunnableResource() {
		this.counter = 0;
		this.counterLock = new ReentrantLock();
	}
    @Override
    public void run() {
        for(int i = 0; i<50; i++){
			try {
                this.increment();
                Thread.sleep(30); // had to add this to create a race condition
            } catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
    }
	
	public int increment() {
		counterLock.lock();
		counter++;
        System.out.printf("%3d %s\n", counter, Thread.currentThread().toString());
		counterLock.unlock();
		return counter;
	}

}
