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
		return (0 <= i && i < nRows) && (0 <= j && j < nColumns);
	}

	public void sweep(int i, int j) {
		matrix[i][j].sweep();
	}

	public void flag(int i, int j) {
		matrix[i][j].flag();
	}

	public void chord(int i, int j) {
		matrix[i][j].chord();
	}

	private void uncover(int i, int j) {
		matrix[i][j].uncover();
	}

	private int getNumber(int i, int j) {
		return matrix[i][j].getNumber();
	}

	private void increment(int i, int j) {
		matrix[i][j].increment();
	}

	private boolean isMine(int i, int j) {
		return matrix[i][j].isMine();
	}

	private boolean isFlagged(int i, int j) {
		return matrix[i][j].isFlagged();
	}

	public void sweepHandle(int i, int j) {
		uncover(i, j);
		if (!isMine(i, j) && getNumber(i, j) == 0) {
			for (Vector vector : Vector.values()) {
				int di = vector.getI();
				int dj = vector.getJ();
				if (contains(i + di, j + dj)) {
					sweep(i + di, j + dj);
				}
			}
		}
	}

	public void chordHandle(int i, int j) {
		if (getNumber(i, j) == neighbourFlags(i, j)) {
			for (Vector vector : Vector.values()) {
				int di = vector.getI();
				int dj = vector.getJ();
				if (contains(i + di, j + dj)) {
					sweep(i + di, j + dj);
				}
			}
		}
	}

	public int neighbourFlags(int i, int j) {
		int nFlags = 0;
		for (Vector vector : Vector.values()) {
			int di = vector.getI();
			int dj = vector.getJ();
			if (contains(i + di, j + dj) && isFlagged(i + di, j + dj)) {
				nFlags++;
			}
		}
		return nFlags;
	}

	public void incrementNeighbours(int i, int j) {
		for (Vector vector : Vector.values()) {
			int di = vector.getI();
			int dj = vector.getJ();
			if (contains(i + di, j + dj) && !isMine(i + di, j + dj)) {
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
