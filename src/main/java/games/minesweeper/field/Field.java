package main.java.games.minesweeper.field;

import java.util.List;

import main.java.games.minesweeper.Minefield;
import main.java.games.minesweeper.field.fieldstate.Covered;
import main.java.games.minesweeper.field.fieldstate.FieldState;
import main.java.games.minesweeper.field.fieldstate.Flagged;
import main.java.games.minesweeper.field.fieldstate.Uncovered;
import main.java.games.minesweeper.field.fieldvalue.FieldNumber;
import main.java.games.minesweeper.field.fieldvalue.FieldValue;
import main.java.games.minesweeper.field.fieldvalue.Mine;

public class Field {
	private Minefield minefield;
	private FieldValue value;
	private FieldState state;
	private List<Field> neighbours;

	public Field(Minefield minefield) {
		this.minefield = minefield;
		value = new FieldNumber(this);
		state = new Covered(this);
	}

	public FieldValue getValue() {
		return value;
	}

	public void setState(FieldState state) {
		this.state = state;
	}

	public List<Field> getNeighbours() {
		return neighbours;
	}

	public void setNeighbours(List<Field> neighbours) {
		this.neighbours = neighbours;
	}

	public void sweep() {
		state.sweep();
	}

	public void mark() {
		state.mark();
	}

	public void chord() {
		state.chord();
	}

	public void layMine() {
		value = new Mine(this);
	}

	public void uncover() {
		state = new Uncovered(this);
		value.uncover();
	}

	public void flag() {
		state = new Flagged(this);
	}

	public int getNumber() {
		return ((FieldNumber) value).getNumber();
	}

	public void increment() {
		((FieldNumber) value).increment();
	}

	public boolean isMine() {
		return value instanceof Mine;
	}

	public boolean isFlagged() {
		return state instanceof Flagged;
	}

	public int neighbourFlags() {
		int nFlags = 0;
		for (Field neighbour : neighbours)
			if (neighbour.isFlagged())
				nFlags++;
		return nFlags;
	}

	public void incrementNeighbours() {
		for (Field neighbour : neighbours)
			if (!neighbour.isMine())
				neighbour.increment();
	}

	public void incrementNumberOfFlags() {
		minefield.incrementNumberOfFlags();
	}

	public void decrementNumberOfFlags() {
		minefield.decrementNumberOfFlags();
	}

	public void detonate() {
		minefield.detonate();
	}

	public void decrementToUncover() {
		minefield.decrementToUncover();
	}

	@Override
	public String toString() {
		return state.toString();
	}
}
