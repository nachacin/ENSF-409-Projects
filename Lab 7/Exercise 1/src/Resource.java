import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Since no constructor is provided, int is initialized to 0 after a new
 * instance is created.
 */
public class Resource {

	int counter;
	private Lock counterLock;

	public Resource() {
		this.counter = 0;
		this.counterLock = new ReentrantLock();
	}
	
	public int increment() {
		counterLock.lock();
		counter++;
		counterLock.unlock();
		return counter;
	}
}
