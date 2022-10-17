package main.java.games.minesweeper;

import java.util.ArrayList;
import java.util.List;

import main.java.games.minesweeper.field.Field;

public class Minefield {
	private int nRows;
	private int nColumns;
	private int nFlags;
	private Field[][] matrix;

	public Minefield(int nRows, int nColumns) {
		this.nRows = nRows;
		this.nColumns = nColumns;
		nFlags = 0;
		matrix = new Field[nRows][nColumns];

		for (int i = 0; i < nRows; i++)
			for (int j = 0; j < nColumns; j++)
				matrix[i][j] = new Field(this);

		for (int i = 0; i < nRows; i++)
			for (int j = 0; j < nColumns; j++)
				matrix[i][j].setNeighbours(getNeighbours(i, j));
	}

	public int getNRows() {
		return nRows;
	}

	public int getNColumns() {
		return nColumns;
	}
	
	public int getNFlags() {
		return nFlags;
	}

	public Field get(int i, int j) {
		return matrix[i][j];
	}

	public boolean contains(int i, int j) {
		return (0 <= i && i < nRows) && (0 <= j && j < nColumns);
	}

	public List<Field> getNeighbours(int i, int j) {
		List<Field> neighbours = new ArrayList<Field>();
		for (Vector vector : Vector.values()) {
			int di = vector.getI();
			int dj = vector.getJ();
			if (contains(i + di, j + dj))
				neighbours.add(matrix[i + di][j + dj]);
		}
		return neighbours;
	}

	public void sweep(int i, int j) {
		matrix[i][j].sweep();
	}

	public void mark(int i, int j) {
		matrix[i][j].mark();
	}

	public void chord(int i, int j) {
		matrix[i][j].chord();
	}

	public void incrementNFlags() {
		nFlags++;
	}

	public void decrementNFlags() {
		nFlags--;
	}

	public void detonate() {
	}

	public void uncoverMines() {
	}

	public void decrementToUncover() {
	}

	public void flagMines() {
	}

	@Override
	public String toString() {
		String str = new String();
		for (int i = 0; i < nRows; i++) {
			for (int j = 0; j < nColumns; j++)
				str += matrix[i][j] + " ";
			str += "\n";
		}
		return str;
	}
}
