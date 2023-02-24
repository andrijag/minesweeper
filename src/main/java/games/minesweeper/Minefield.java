package main.java.games.minesweeper;

import java.util.ArrayList;
import java.util.List;

import main.java.games.minesweeper.field.Field;
import main.java.games.minesweeper.field.fieldvalue.ExplosiveState;
import main.java.games.minesweeper.utils.Vector;

public class Minefield {
	private int numberOfRows;
	private int numberOfColumns;
	private int numberOfFields;
	private int numberOfUncoveredFields;
	private int numberOfFlags;
	private Field[][] fields;
	private List<Field> fieldsWithMines;
	private ExplosiveState state;

	public Minefield(int numberOfRows, int numberOfColumns) {
		this.numberOfRows = numberOfRows;
		this.numberOfColumns = numberOfColumns;
		numberOfFields = numberOfRows * numberOfColumns;
		numberOfUncoveredFields = 0;
		numberOfFlags = 0;
		fields = new Field[numberOfRows][numberOfColumns];
		fieldsWithMines = new ArrayList<Field>();
		state = ExplosiveState.LIVE;

		for (int i = 0; i < numberOfRows; i++)
			for (int j = 0; j < numberOfColumns; j++)
				fields[i][j] = new Field(this);

		for (int i = 0; i < numberOfRows; i++)
			for (int j = 0; j < numberOfColumns; j++)
				fields[i][j].setNeighbours(getNeighbours(i, j));
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

	public Field getField(int i, int j) {
		return fields[i][j];
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
				neighbours.add(fields[i + di][j + dj]);
		}
		return neighbours;
	}

	public void addFieldWithMine(Field field) {
		fieldsWithMines.add(field);
	}

	public int getNumberOfMines() {
		return fieldsWithMines.size();
	}

	public void sweep(int i, int j) {
		fields[i][j].sweep();
	}

	public void mark(int i, int j) {
		fields[i][j].mark();
	}

	public void chord(int i, int j) {
		fields[i][j].chord();
	}

	public void incrementNumberOfUncoveredFields() {
		numberOfUncoveredFields++;
	}

	public void incrementNumberOfFlags() {
		numberOfFlags++;
	}

	public void decrementNumberOfFlags() {
		numberOfFlags--;
	}

	public void detonate() {
		state = ExplosiveState.DETONATED;
	}
	
	public boolean isCleared() {
		return numberOfUncoveredFields + getNumberOfMines() == numberOfFields;
	}

	public boolean isDetonated() {
		return state == ExplosiveState.DETONATED;
	}

	public void uncoverMines() {
		for (Field field : fieldsWithMines)
			field.uncover();
	}

	public void flagMines() {
		for (Field field : fieldsWithMines)
			field.flag();
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
