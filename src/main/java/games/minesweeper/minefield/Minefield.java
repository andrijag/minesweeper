package main.java.games.minesweeper.minefield;

import java.util.ArrayList;
import java.util.List;

import main.java.games.minesweeper.util.Vector;

public class Minefield {
	private int numberOfRows;
	private int numberOfColumns;
	private List<Field> fields;

	public Minefield(int numberOfRows, int numberOfColumns) {
		this.numberOfRows = numberOfRows;
		this.numberOfColumns = numberOfColumns;
		fields = new ArrayList<>();

		for (int i = 0; i < numberOfRows; i++)
			for (int j = 0; j < numberOfColumns; j++)
				fields.add(new Field());

		for (int i = 0; i < numberOfRows; i++)
			for (int j = 0; j < numberOfColumns; j++)
				getField(i, j).setNeighbours(getNeighboursOfField(i, j));
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

	public Field getField(int i, int j) {
		return fields.get(i * numberOfColumns + j);
	}

	private List<Field> getNeighboursOfField(int i, int j) {
		List<Field> neighbours = new ArrayList<>();
		for (Vector vector : Vector.values())
			if (contains(i + vector.getI(), j + vector.getJ()))
				neighbours.add(getField(i + vector.getI(), j + vector.getJ()));
		return neighbours;
	}

	private boolean contains(int i, int j) {
		return (0 <= i && i < numberOfRows) && (0 <= j && j < numberOfColumns);
	}

	private List<Field> getFieldsWithMines() {
		List<Field> fieldsWithMines = new ArrayList<Field>();
		for (Field field : fields)
			if (field.isMine())
				fieldsWithMines.add(field);
		return fieldsWithMines;

	}

	private int getNumberOfMines() {
		return getFieldsWithMines().size();
	}

	public int getNumberOfFlags() {
		int numberOfFlags = 0;
		for (Field field : fields)
			if (field.isFlagged())
				numberOfFlags++;
		return numberOfFlags;
	}

	private int getNumberOfUncoveredFields() {
		int numberUncoveredFields = 0;
		for (Field field : fields)
			if (field.isFlagged())
				numberUncoveredFields++;
		return numberUncoveredFields;
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
