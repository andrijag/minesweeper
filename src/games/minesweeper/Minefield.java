package games.minesweeper;

import games.minesweeper.field.Field;

public class Minefield {
	private int nRows;
	private int nColumns;
	private Field[][] matrix;

	public Minefield(int nRows, int nColumns) {
		this.nRows = nRows;
		this.nColumns = nColumns;
		matrix = new Field[nRows][nColumns];
		for (int i = 0; i < nRows; i++) {
			for (int j = 0; j < nColumns; j++) {
				matrix[i][j] = new Field(this, i, j);
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

	public void flag(int i, int j) {
		matrix[i][j].flag();
	}

	public void increment(int i, int j) {
		matrix[i][j].increment();
	}

	public void sweep(int i, int j) {
		matrix[i][j].sweep();
	}

	public void chord(int i, int j) {
		matrix[i][j].chord();
	}

	public boolean isMine(int i, int j) {
		return matrix[i][j].isMine();
	}

	public boolean isFlagged(int i, int j) {
		return matrix[i][j].isFlagged();
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
