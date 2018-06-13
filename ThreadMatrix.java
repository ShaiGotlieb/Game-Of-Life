//class ThreadMatrix represent the threads of game of life with matrix
public class ThreadMatrix {
	//variables
	private LifeThread[][] threadMat;
	private Controller control;
	private int matSize;
	private LifeMatrix lifeMat;

	//constructor - initialize variables and new threads in matrix
	public ThreadMatrix(int size, LifeMatrix lifeMat, Controller control, MainMonitor monitor) {
		threadMat = new LifeThread[size][size];
		this.lifeMat = lifeMat;
		this.control = control;
		this.matSize = size;
		
		//create new threads in matrix cells
		for (int i = 0; i < size; i++)
			for (int j = 0; j < size; j++)
				threadMat[i][j] = new LifeThread(control, lifeMat, monitor, i, j);
	}

	//start threads that were initialized
	public void startAllThreadsGameOn() {
		for (int i = 0; i < matSize; i++)
			for (int j = 0; j < matSize; j++)
				threadMat[i][j].start();
	}
	
	//tell others that day has passed
	public void lifeDay() {
		//copy last day matrix
		lifeMat.copyMat();
		//increase cycle size
		lifeMat.incCycle();
		//wake up all threads
		control.wakeAllThreads();
	}
}//end of class ThreadMatrix
