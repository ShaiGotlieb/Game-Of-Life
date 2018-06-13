import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//class MVCCOntroller 
public class MVCController {
	//variables
	private LifeMatrix model;
	private int cells;
	private MyPanel[][] panels;
	private MainMonitor monitor;

	//constructor - initialize variables
	public MVCController(LifeMatrix mod, MyFrame frame, MainMonitor mon) {
		model = mod;
		cells = frame.getCellsNum();
		monitor = mon;
		//create matrix of panels with size of cells
		panels = new MyPanel[cells][cells];
		//keep references to panel
		for (int i = 0; i < cells; i++)
			for (int j = 0; j < cells; j++) {
				panels[i][j] = new MyPanel();
				frame.addToMainPanel(panels[i][j]);
			}
		frame.setSize(frame.getSize());
		frame.setVisible(true);
	}
	//listener for restart button
	class restartListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// wait for all threads to finish
			monitor.waitForThreads();
			// restart
			model.restart();
		}
	}

	//update panels look
	public void updateUI() {
		for (int i = 0; i < cells; i++)
			for (int j = 0; j < cells; j++) {
				panels[i][j].setColor(model.getLife(i, j));
			}
	}
}//end of class MVCControl
