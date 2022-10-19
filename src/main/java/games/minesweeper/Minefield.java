package main.java.games.minesweeper;

import java.util.ArrayList;
import java.util.List;

import main.java.games.minesweeper.field.Field;

public class Minefield {
	private int numberOfRows;
	private int numberOfColumns;
	private int numberOfMines;
	private int numberOfFlags;
	private int numberOfUncoveredFields;
	private int numberOfFields;
	private boolean detonated;
	private Field[][] matrix;
	private List<Field> fieldsWithMines;

	public Minefield(int numberOfRows, int numberOfColumns, int numberOfMines) {
		this.numberOfRows = numberOfRows;
		this.numberOfColumns = numberOfColumns;
		this.numberOfMines = numberOfMines;
		numberOfFlags = 0;
		numberOfUncoveredFields = 0;
		numberOfFields = numberOfRows * numberOfColumns;
		detonated = false;
		matrix = new Field[numberOfRows][numberOfColumns];
		fieldsWithMines = new ArrayList<Field>();

		for (int i = 0; i < numberOfRows; i++)
			for (int j = 0; j < numberOfColumns; j++)
				matrix[i][j] = new Field(this);

		for (int i = 0; i < numberOfRows; i++)
			for (int j = 0; j < numberOfColumns; j++)
				matrix[i][j].setNeighbours(getNeighbours(i, j));
	}

	public int getNumberOfRows() {
		return numberOfRows;
	}

	public int getNumberOfColumns() {
		return numberOfColumns;
	}

	public int getNumberOfFlags() {
		return numberOfFlags;
	}

	public Field get(int i, int j) {
		return matrix[i][j];
	}

	public boolean contains(int i, int j) {
		return (0 <= i && i < numberOfRows) && (0 <= j && j < numberOfColumns);
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
	
	public void addFieldWithMine(Field field) {
		fieldsWithMines.add(field);
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

	public void incrementNumberOfFlags() {
		numberOfFlags++;
	}

	public void decrementNumberOfFlags() {
		numberOfFlags--;
	}

	public void detonate() {
		detonated = true;
	}

	public void uncoverMines() {
		for (Field field : fieldsWithMines)
			field.uncover();
	}

	public void incrementNumberOfUncoveredFields() {
		numberOfUncoveredFields++;
	}

	public void flagMines() {
		for (Field field : fieldsWithMines)
			field.flag();
	}

	public boolean isCleared() {
		return numberOfUncoveredFields + numberOfMines == numberOfFields;
	}

	public boolean isDetonated() {
		return detonated;
	}

	@Override
	public String toString() {
		String str = new String();
		for (int i = 0; i < numberOfRows; i++) {
			for (int j = 0; j < numberOfColumns; j++)
				str += matrix[i][j] + " ";
			str += "\n";
		}
		return str;
	}
}
