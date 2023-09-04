package main.java.games.minesweeper.model.minefield;

import java.util.ArrayList;
import java.util.List;

public class Minefield {
	private int numberOfRows;
	private int numberOfColumns;
	private Field[][] fields;

	public Minefield(int numberOfRows, int numberOfColumns) {
		this.numberOfRows = numberOfRows;
		this.numberOfColumns = numberOfColumns;
		fields = new Field[numberOfRows][numberOfColumns];

		for (int row = 0; row < numberOfRows; row++)
			for (int column = 0; column < numberOfColumns; column++)
				fields[row][column] = new Field();

		for (int row = 0; row < numberOfRows; row++)
			for (int column = 0; column < numberOfColumns; column++)
				fields[row][column].setNeighbours(getNeighboursOfField(row, column));
	}

	public int getNumberOfRows() {
		return numberOfRows;
	}

	public int getNumberOfColumns() {
		return numberOfColumns;
	}

	public int getNumberOfFields() {
		return numberOfRows * numberOfColumns;
	}

	public Field getField(int row, int column) {
		return fields[row][column];
	}

	private List<Field> getNeighboursOfField(int row, int column) {
		List<Field> neighbours = new ArrayList<>();
		for (Vector vector : Vector.values())
			if (contains(row + vector.getI(), column + vector.getJ()))
				neighbours.add(fields[row + vector.getI()][column + vector.getJ()]);
		return neighbours;
	}

	private boolean contains(int row, int column) {
		return (0 <= row && row < numberOfRows) && (0 <= column && column < numberOfColumns);
	}

	public int getNumberOfFlags() {
		return getFieldsWithFlags().size();
	}
	
	private List<Field> getFieldsWithFlags() {
		List<Field> fieldsWithFlags = new ArrayList<Field>();
		for (int row = 0; row < numberOfRows; row++)
			for (int column = 0; column < numberOfColumns; column++)
				if (fields[row][column].isFlagged())
					fieldsWithFlags.add(fields[row][column]);
		return fieldsWithFlags;
	}

	private int getNumberOfUncoveredFields() {
		int numberOfUncoveredFields = 0;
		for (int row = 0; row < numberOfRows; row++)
			for (int column = 0; column < numberOfColumns; column++)
				if (fields[row][column].isUncovered())
					numberOfUncoveredFields++;
		return numberOfUncoveredFields;
	}

	private int getNumberOfMines() {
		return getFieldsWithMines().size();
	}

	private List<Field> getFieldsWithMines() {
		List<Field> fieldsWithMines = new ArrayList<Field>();
		for (int row = 0; row < numberOfRows; row++)
			for (int column = 0; column < numberOfColumns; column++)
				if (fields[row][column].isMine())
					fieldsWithMines.add(fields[row][column]);
		return fieldsWithMines;

	}

	public boolean isDetonated() {
		for (Field field : getFieldsWithMines())
			if (field.isDetonated())
				return true;
		return false;
	}

	public boolean isCleared() {
		return getNumberOfUncoveredFields() + getNumberOfMines() == getNumberOfFields();
	}

	public void uncoverMines() {
		for (Field field : getFieldsWithMines())
			if (!field.isFlagged())
				field.uncover();
	}
	
	public void checkFlags() {
		for (Field field : getFieldsWithFlags())
			if (!field.isMine())
				field.setFalselyFlagged();
	}

	public void flagMines() {
		for (Field field : getFieldsWithMines())
			field.flag();
	}

	@Override
	public String toString() {
		String str = new String();
		for (int row = 0; row < numberOfRows; row++) {
			for (int column = 0; column < numberOfColumns; column++)
				str += getField(row, column) + " ";
			str += "\n";
		}
		return str;
	}
}
