//class Controller handle life game flow
public class Controller {
	//variables of Controller
	//number of active threads
	private int activeThreads;
	//total number of threads
	private int numOfThreads;
	//threads that are waiting
	private int waitingThreads;
	
	//constructor - initialize variables
	public Controller(int num) {
		activeThreads = num;
		numOfThreads = num;
		waitingThreads = 0;
	}
	
	//synchronized method to wake up all threads
		public synchronized void wakeAllThreads() {
			activeThreads = numOfThreads;
			notifyAll();
		}
	
	//synchronized method to notify that thread is done
	public synchronized void finished(MainMonitor monitor) {
		//decrease amount of active threads
		activeThreads--;
		//make monitor wake up when all active threads done by notify all threads
		if (activeThreads == 0)
			monitor.makeAwake();
		try {
			wait();
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	//synchronized method that wait for other threads before updating
	public synchronized void toUpdate() {
		//increase number of threads that wait
		waitingThreads += 1;
		
		//if all threads waiting - notify all
		if (waitingThreads == numOfThreads) {
			this.notifyAll();
			
			//re-set threads that wait
			waitingThreads = 0;
		}
		else {
			try {
				wait();
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}
	}
}//end of class Controller
