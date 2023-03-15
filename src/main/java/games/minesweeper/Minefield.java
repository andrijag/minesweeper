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

	public List<Field> getFields() {
		List<Field> fields = new ArrayList<>();
		for (int i = 0; i < numberOfRows; i++)
			for (int j = 0; j < numberOfColumns; j++)
				fields.add(this.fields[i][j]);
		return fields;
	}

	private List<Field> getNeighboursOfField(int i, int j) {
		List<Field> neighbours = new ArrayList<>();
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

	public int getNumberOfMines() {
		return fieldsWithMines.size();
	}

	public int getNumberOfFlags() {
		return fieldsWithFlags.size();
	}

	public void layMine(Field field) {
		field.layMine();
		addFieldWithMine(field);
	}

	private void addFieldWithMine(Field field) {
		fieldsWithMines.add(field);
	}

	public void uncover(Field field) {
		field.uncover();
		incrementNumberOfUncoveredFields();
	}

	private void incrementNumberOfUncoveredFields() {
		numberOfUncoveredFields++;
	}

	public void mark(Field field) {
		field.mark();
		if (field.isFlagged())
			addFieldWithFlag(field);
		else
			removeFieldWithFlag(field);
	}

	private void addFieldWithFlag(Field field) {
		fieldsWithFlags.add(field);
	}

	private void removeFieldWithFlag(Field field) {
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
			uncover(field);
	}

	public void flagMines() {
		for (Field field : fieldsWithMines)
			flag(field);
	}

	private void flag(Field field) {
		field.flag();
		addFieldWithFlag(field);
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
