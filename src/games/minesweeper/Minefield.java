package games.minesweeper;

public class Minefield {
	int nRows;
	int nColumns;
	Field[][] grid;
	
	public Minefield(int nRows, int nColumns) {
		this.nRows = nRows;
		this.nColumns = nColumns;
		grid = new Field[nRows][nColumns];
		for (int i = 0; i < nRows; i++) {
			for (int j = 0; j < nColumns; j++) {
				grid[i][j] = new Field();
			}
		}
	}
	
	public int getNRows() {
		return nRows;
	}
	
	public int getNColumns() {
		return nColumns;
	}
	
	public Field get(int i, int j) {
		return grid[i][j];
	}
}
