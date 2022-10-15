package games.minesweeper;

import java.util.ArrayList;
import java.util.List;

import games.minesweeper.field.Field;

public class Minefield {
	private Minesweeper game;
	private int nRows;
	private int nColumns;
	private Field[][] matrix;

	public Minefield(Minesweeper game, int nRows, int nColumns) {
		this.game = game;
		this.nRows = nRows;
		this.nColumns = nColumns;
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

	public void sweepRecursion(int i, int j) {
		matrix[i][j].sweepRecursion();
	}

	public void mark(int i, int j) {
		matrix[i][j].mark();
	}

	public void chord(int i, int j) {
		matrix[i][j].chord();
	}

	private void uncover(int i, int j) {
		matrix[i][j].uncover();
	}

	private void flag(int i, int j) {
		matrix[i][j].flag();
	}

	private boolean isMine(int i, int j) {
		return matrix[i][j].isMine();
	}

	public void incrementNFlags() {
		game.incrementNFlags();
	}

	public void decrementNFlags() {
		game.decrementNFlags();
	}

	public void detonate() {
		game.gameOver();
	}

	public void uncoverMines() {
		for (int i = 0; i < nRows; i++)
			for (int j = 0; j < nColumns; j++)
				if (isMine(i, j))
					uncover(i, j);
	}

	public void decrementToUncover() {
		game.decrementToUncover();
	}

	public void validate() {
		game.validate();
	}

	public void flagMines() {
		for (int i = 0; i < nRows; i++)
			for (int j = 0; j < nColumns; j++)
				if (isMine(i, j))
					flag(i, j);
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
