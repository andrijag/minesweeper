package main.java.games.minesweeper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import main.java.games.minesweeper.field.Field;
import main.java.games.minesweeper.utils.Vector;

public class Minefield {
	private int numberOfRows;
	private int numberOfColumns;
	private int numberOfUncoveredFields;
	private Field[][] fields;
	private List<Field> fieldsWithMines;
	private Set<Field> fieldsWithFlags;

	public Minefield(int numberOfRows, int numberOfColumns) {
		this.numberOfRows = numberOfRows;
		this.numberOfColumns = numberOfColumns;
		numberOfUncoveredFields = 0;
		fields = new Field[numberOfRows][numberOfColumns];
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
		List<Field> neighbours = new ArrayList<Field>();
		for (Vector vector : Vector.values()) {
			int di = vector.getI();
			int dj = vector.getJ();
			if (contains(i + di, j + dj))
				neighbours.add(fields[i + di][j + dj]);
		}
		return neighbours;
	}

	private boolean contains(int i, int j) {
		return (0 <= i && i < numberOfRows) && (0 <= j && j < numberOfColumns);
	}

	public void addFieldWithMine(Field field) {
		fieldsWithMines.add(field);
	}

	public int getNumberOfMines() {
		return fieldsWithMines.size();
	}

	public void addFieldWithFlag(Field field) {
		fieldsWithFlags.add(field);
	}

	public void removeFieldWithFlag(Field field) {
		fieldsWithFlags.remove(field);
	}

	public int getNumberOfFlags() {
		return fieldsWithFlags.size();
	}

	public void incrementNumberOfUncoveredFields() {
		numberOfUncoveredFields++;
	}

	public boolean isCleared() {
		return numberOfUncoveredFields + getNumberOfMines() == getNumberOfFields();
	}

	public boolean isDetonated() {
		for (Field field : fieldsWithMines)
			if (field.isDetonated())
				return true;
		return false;
	}

	public void uncoverMines() {
		for (Field field : fieldsWithMines)
			uncover(field);
	}

	public void flagMines() {
		for (Field field : fieldsWithMines)
			flag(field);
	}

	public void flag(Field field) {
		field.flag();
		fieldsWithFlags.add(field);
	}

	public void layMine(Field field) {
		field.layMine();
		fieldsWithMines.add(field);
	}

	public void uncover(Field field) {
		field.uncover();
		numberOfUncoveredFields++;
	}

	public void mark(Field field) {
		field.mark();
		if (field.isFlagged())
			fieldsWithFlags.add(field);
		else
			fieldsWithFlags.remove(field);
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
