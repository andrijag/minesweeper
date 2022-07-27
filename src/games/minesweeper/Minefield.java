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

	public boolean contains(int i, int j) {
		return 0 <= i && i < nRows && 0 <= j && j < nColumns;
	}

	public void layMine(int i, int j) {
		matrix[i][j].layMine();
	}

	public void increment(int i, int j) {
		matrix[i][j].increment();
	}

	public void uncover(int i, int j) {
		matrix[i][j].uncover();
	}

	public void flag(int i, int j) {
		matrix[i][j].flag();
	}

	public boolean isMine(int i, int j) {
		return matrix[i][j].isMine();
	}

	public boolean isUncovered(int i, int j) {
		return matrix[i][j].isUncovered();
	}

	public void incrementAdjecent(int i, int j) {
		for (Vector vector : Vector.values()) {
			int di = vector.getI();
			int dj = vector.getJ();
			if (contains(i + di, j + dj)) {
				increment(i + di, j + dj);
			}
		}
	}
	
	@Override
	public String toString() {
		String str = new String();
		for (int i = 0; i < nRows; i++) {
			for (int j = 0; j < nColumns; j++) {
				str += matrix[i][j] + " ";
			}
			str += "\n";
		}
		return str;
	}
}
