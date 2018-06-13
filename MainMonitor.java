//class MainMonitor handle functions of waiting
public class MainMonitor {
	
	//synchronized method to make monitor wait
	public synchronized void waitForThreads() {
		try {
			wait();
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	//synchronized method to wake up all threads
	public synchronized void makeAwake() {
		notifyAll();
	}
}//end of class MainMonitor
