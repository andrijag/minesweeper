package main.java.games.minesweeper.model;

import java.util.ArrayList;
import java.util.List;

import main.java.games.minesweeper.model.util.Vector;

public class Minefield {
	private int numberOfRows;
	private int numberOfColumns;
	private Field[][] fields;

	public Minefield(int numberOfRows, int numberOfColumns) {
		this.numberOfRows = numberOfRows;
		this.numberOfColumns = numberOfColumns;
		fields = new Field[numberOfRows][numberOfColumns];

		for (int i = 0; i < numberOfRows; i++)
			for (int j = 0; j < numberOfColumns; j++)
				fields[i][j] = new Field();

		for (int i = 0; i < numberOfRows; i++)
			for (int j = 0; j < numberOfColumns; j++)
				fields[i][j].setNeighbours(getNeighboursOfField(i, j));
	}

	public int getNumberOfRows() {
		return numberOfRows;
	}

	public int getNumberOfColumns() {
		return numberOfColumns;
	}

	public Field getField(int i, int j) {
		return fields[i][j];
	}

	private List<Field> getNeighboursOfField(int i, int j) {
		List<Field> neighbours = new ArrayList<>();
		for (Vector vector : Vector.values())
			if (contains(i + vector.getI(), j + vector.getJ()))
				neighbours.add(fields[i + vector.getI()][j + vector.getJ()]);
		return neighbours;
	}

	private boolean contains(int i, int j) {
		return (0 <= i && i < numberOfRows) && (0 <= j && j < numberOfColumns);
	}

	public int getNumberOfFlags() {
		int numberOfFlags = 0;
		for (int i = 0; i < numberOfRows; i++)
			for (int j = 0; j < numberOfColumns; j++)
				if (fields[i][j].isFlagged())
					numberOfFlags++;
		return numberOfFlags;
	}

	private List<Field> getFieldsWithMines() {
		List<Field> fieldsWithMines = new ArrayList<Field>();
		for (int i = 0; i < numberOfRows; i++)
			for (int j = 0; j < numberOfColumns; j++)
				if (fields[i][j].isMine())
					fieldsWithMines.add(fields[i][j]);
		return fieldsWithMines;

	}

	public boolean isDetonated() {
		for (Field field : getFieldsWithMines())
			if (field.isDetonated())
				return true;
		return false;
	}

	public boolean isCleared() {
		for (int i = 0; i < numberOfRows; i++)
			for (int j = 0; j < numberOfColumns; j++)
				if (!fields[i][j].isMine() && !fields[i][j].isUncovered())
					return false;
		return true;
	}

	public void uncoverMines() {
		for (Field field : getFieldsWithMines())
			field.uncover();
	}

	public void flagMines() {
		for (Field field : getFieldsWithMines())
			field.flag();
	}

	@Override
	public String toString() {
		String str = new String();
		for (int i = 0; i < numberOfRows; i++) {
			for (int j = 0; j < numberOfColumns; j++)
				str += getField(i, j) + " ";
			str += "\n";
		}
		return str;
	}
}
