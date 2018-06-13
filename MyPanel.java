import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

//class MyPanel represent a cell in the game
public class MyPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private final int SIZE = 40;
	private Color color;
	private final Color DEAD = Color.WHITE;
	private final Color ALIVE = Color.BLACK;

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		//set the color and fill the cell
		g.setColor(color);
		g.fillRect(0, 0, SIZE, SIZE);
	}

	//change color of cell by its status
	public void setColor(boolean life) {
		if (life == false)
			color = DEAD;
		else
			color = ALIVE;
	}
}//end of class MyPanel
