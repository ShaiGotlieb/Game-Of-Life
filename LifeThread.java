//class LifeThread is the actual thread to be running
public class LifeThread extends Thread {
	//variables
	LifeMatrix lifeMat;
	private Controller control;
	private int row;
	private int col;
	private MainMonitor monitor;
	
	//constructor - initialize variables
	public LifeThread(Controller cont, LifeMatrix mat, MainMonitor mon, int i, int j) {
		control = cont;
		lifeMat = mat;
		monitor = mon;
		row = i;
		col = j;
	}

	@Override
	//run method for thread inmlife game
	public void run() {	
		while(!(lifeMat.isGameOver())) {
			//check the cells
			boolean life = lifeMat.checkCells(row, col);
			//wait for threads
			control.toUpdate();
			//update
			lifeMat.cellUpdate(row, col, life);
			//let control know that finished
			control.finished(monitor);
		}
	}	
}//end of class LifeThread
