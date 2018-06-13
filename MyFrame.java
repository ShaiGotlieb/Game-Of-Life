import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

//class MyFrame represent GUI of the game
public class MyFrame extends JFrame {
	//serializeable
	private static final long serialVersionUID = 1L;
	private final int SIZE = 50;
	private JPanel mainPanel;
	private JButton restart;
	private int cells;
	
	//constructor - initialize gui
	public MyFrame(int numOfCells) {
		cells = numOfCells;

		//create mainPanel
		mainPanel = new JPanel();
		mainPanel.setLayout(new GridLayout(cells, cells));
		restart = new JButton("restart");
		restart.setEnabled(true);
		setLayout(new BorderLayout(10, 10));
		add(mainPanel, BorderLayout.CENTER);
		add(restart, BorderLayout.SOUTH);
		setSize(cells * SIZE, cells * SIZE);

	}
	
	//restart when button is pressed
	public void setRestartActionListener(ActionListener listener) {
		restart.addActionListener(listener);
	}
	
	//add to mainPanel
	public void addToMainPanel(MyPanel panel) {
		mainPanel.add(panel);
	}
	
	//getter
	public int getCellsNum() {
		return cells;
	}
}//end of class MyFrame
