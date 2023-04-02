package main.java.games.minesweeper.minefield;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import main.java.games.minesweeper.util.Vector;

public class Minefield {
	private int numberOfRows;
	private int numberOfColumns;
	private Field[][] fields;
	private int numberOfUncoveredFields;
	private List<Field> fieldsWithMines;
	private Set<Field> fieldsWithFlags;

	public Minefield(int numberOfRows, int numberOfColumns) {
		this.numberOfRows = numberOfRows;
		this.numberOfColumns = numberOfColumns;
		fields = new Field[numberOfRows][numberOfColumns];
		numberOfUncoveredFields = 0;
		fieldsWithMines = new ArrayList<>();
		fieldsWithFlags = new HashSet<>();

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

	public int getNumberOfFields() {
		return numberOfRows * numberOfColumns;
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

	public int getNumberOfMines() {
		return fieldsWithMines.size();
	}

	public int getNumberOfFlags() {
		return fieldsWithFlags.size();
	}

	public void layMine(Field field) {
		field.layMine();
		fieldsWithMines.add(field);
	}

	public void uncover(Field field) {
		field.uncover();
		if (field.isMine())
			field.detonate();
		else
			numberOfUncoveredFields++;
	}

	public void mark(Field field) {
		field.mark();
		if (field.isFlagged())
			fieldsWithFlags.add(field);
		else
			fieldsWithFlags.remove(field);
	}

	public boolean isDetonated() {
		for (Field field : fieldsWithMines)
			if (field.isDetonated())
				return true;
		return false;
	}

	public boolean isCleared() {
		return numberOfUncoveredFields + getNumberOfMines() == getNumberOfFields();
	}

	public void uncoverMines() {
		for (Field field : fieldsWithMines)
			field.uncover();
	}

	public void flagMines() {
		for (Field field : fieldsWithMines)
			flag(field);
	}

	private void flag(Field field) {
		field.flag();
		fieldsWithFlags.add(field);
	}

	@Override
	public String toString() {
		String str = new String();
		for (int i = 0; i < numberOfRows; i++) {
			for (int j = 0; j < numberOfColumns; j++)
				str += fields[i][j] + " ";
			str += "\n";
		}
		return str;
	}
}
