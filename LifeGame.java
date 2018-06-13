import javax.swing.JOptionPane;

//Class LifeGame represent the game of life as written in MMN15 - openU
public class LifeGame {
	public void startGame() {
		//variables
		//interval is the time to be delayed
		int interval = 1000;
		int decision = JOptionPane.YES_OPTION;

		//get input of matrix size from the user
		int userSize = Integer.parseInt(JOptionPane.showInputDialog("Please Enter Matrix Size: "));

		//Create new objects of the game
		Controller control = new Controller(userSize * userSize);
		LifeMatrix lifeMat = new LifeMatrix(userSize);
		MainMonitor handler = new MainMonitor();
		ThreadMatrix threadMat = new ThreadMatrix(userSize, lifeMat, control, handler);

		//create UI
		MyFrame lifeFrame = new MyFrame(userSize);
		MVCController cont = new MVCController(lifeMat, lifeFrame, handler);
		lifeFrame.setVisible(true);
		
		//starting threads of life game
		threadMat.startAllThreadsGameOn();
		
		while (decision == JOptionPane.YES_OPTION) {
			//day is over
			threadMat.lifeDay();
			
			//wait for threads to finish
			handler.waitForThreads();
			
			//if game is over or still playing
			lifeMat.checkPlay();
			
			//update user interface and refresh
			cont.updateUI();
			lifeFrame.repaint();
			
			//create a delay
			try {
				Thread.sleep(interval);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
			
//			//game is over dialog box
//			if (lifeMat.isGameOver()) {
//				decision = JOptionPane.showConfirmDialog(null, "Game Over - Would you like to restart game?");
//				if (decision == JOptionPane.YES_OPTION)
//					lifeMat.restart();
//			}
		}
		//dispose
		lifeFrame.dispose();

	}
}
