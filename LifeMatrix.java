import java.util.Random;

//class Matrix represent the matrix of life game and handle logic
public class LifeMatrix {
	//variables of matrix
	private boolean[][] matrix;
	private boolean[][] lastMat;
	private boolean gameOverFlag;
	public static int size;
	private int cycle;

	//constructor - initialize variables of Matrix class and create random cells in matrix
	public LifeMatrix(int _size) {
		size = _size;
		matrix = new boolean[size][size];
		lastMat = new boolean[size][size];
		cycle = 0;
		gameOverFlag = false;

		//create random cells starting position
		Random rand = new Random();
		for (int i = 0; i < size; i++)
			for (int j = 0; j < size; j++)
				matrix[i][j] = rand.nextBoolean();
	}


	// update a site
	public boolean checkCells(int i, int j) {
		//neighbors
		int counter = 0;
		boolean isAlive = matrix[i][j];

		//check neighbors
		if (i + 1 < size && j + 1 < size)
			if (matrix[i + 1][j + 1] == true)
				counter++;
		if (i > 0 && j > 0)
			if (matrix[i - 1][j - 1] == true)
				counter++;
		if (i > 0 && j + 1 < size)
			if (matrix[i - 1][j + 1] == true)
				counter++;
		if (i + 1 < size && j > 0)
			if (matrix[i + 1][j - 1] == true)
				counter++;
		if (i + 1 < size && matrix[i + 1][j] == true)
			counter++;
		if (j + 1 < size && matrix[i][j + 1] == true)
			counter++;
		if (i > 0 && matrix[i - 1][j] == true)
			counter++;
		if (j > 0 && matrix[i][j - 1] == true)
			counter++;

		//new birth
		if ((!isAlive) && counter == 3)
			return true; 
		//alive
		if (isAlive && (counter == 2 || counter == 3))
			return true;
		//distinguish
		if (isAlive && (counter <= 1 || counter >= 4))
			return false;
		else
			return false;
	}

	//update cell
	public void cellUpdate(int i, int j, boolean life) {
		matrix[i][j] = life;
	}

	//check if game is over
	public boolean isGameOver() {
		return gameOverFlag;
	}

	//check if a game is still on playing or not
	public void checkPlay() {
		for (int i = 0; i < size; i++)
			for (int j = 0; j < size; j++)
				if (matrix[i][j] != lastMat[i][j])
					return;
		gameOverFlag = true;
	}
	
	//copy matrix
	public void copyMat() {
		for (int i = 0; i < size; i++)
			for (int j = 0; j < size; j++)
				this.lastMat[i][j] = this.matrix[i][j];
	}

	//increase number of cycle
	public void incCycle() {
		cycle++;
	}
	
	//getters
	public boolean[][] getMatrix() {
		return matrix;
	}

	public int getCycle() {
		return cycle;
	}

	public int getSize() {
		return size;
	}

	public boolean getLife(int i, int j) {
		return matrix[i][j];
	}

	//restart game by re-setting
	public void restart() {
		gameOverFlag = false;
		cycle = 0;
		Random rand = new Random();
		for (int i = 0; i < size; i++)
			for (int j = 0; j < size; j++)
				matrix[i][j] = rand.nextBoolean();
	}
}//end of class Matrix
