package games.minesweeper;

import games.minesweeper.field.Field;

public class Minefield {
	int nRows;
	int nColumns;
	Field[][] matrix;
	
	public Minefield(int nRows, int nColumns) {
		this.nRows = nRows;
		this.nColumns = nColumns;
		matrix = new Field[nRows][nColumns];
		for (int i = 0; i < nRows; i++) {
			for (int j = 0; j < nColumns; j++) {
				matrix[i][j] = new Field();
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
		return matrix[i][j];
	}
}
