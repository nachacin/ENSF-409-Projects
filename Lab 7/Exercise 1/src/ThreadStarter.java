public class ThreadStarter {
    public static void main(String args[]) {
        RunnableResource aResource = new RunnableResource();
		new Thread(aResource).start();
        new Thread(aResource).start();
	}
}
