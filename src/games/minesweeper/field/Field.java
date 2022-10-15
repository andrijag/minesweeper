package games.minesweeper.field;

import games.minesweeper.Minefield;
import games.minesweeper.field.fieldstate.Covered;
import games.minesweeper.field.fieldstate.FieldState;
import games.minesweeper.field.fieldstate.Flagged;
import games.minesweeper.field.fieldstate.Uncovered;
import games.minesweeper.field.fieldvalue.FieldNumber;
import games.minesweeper.field.fieldvalue.FieldValue;
import games.minesweeper.field.fieldvalue.Mine;

public class Field {
	private Minefield minefield;
	private int i;
	private int j;
	private FieldValue value;
	private FieldState state;

	public Field(Minefield minefield, int i, int j) {
		this.minefield = minefield;
		this.i = i;
		this.j = j;
		value = new FieldNumber(this);
		state = new Covered(this);
	}

	public FieldValue getValue() {
		return value;
	}

	public void setState(FieldState state) {
		this.state = state;
	}

	public void sweep() {
		state.sweep();
	}

	public void sweepRecursion() {
		state.sweepRecursion();
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

	public void sweepHandle() {
		minefield.sweepHandle(i, j);
	}

	public void chordHandle() {
		minefield.chordHandle(i, j);
	}

	public void incrementNeighbours() {
		minefield.incrementNeighbours(i, j);
	}

	public void incrementNFlags() {
		minefield.incrementNFlags();
	}

	public void decrementNFlags() {
		minefield.decrementNFlags();
	}

	public void detonate() {
		minefield.detonate();
	}

	public void decrementToUncover() {
		minefield.decrementToUncover();
	}

	public void validate() {
		minefield.validate();
	}

	@Override
	public String toString() {
		return state.toString();
	}
}
