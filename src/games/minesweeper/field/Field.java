package games.minesweeper.field;

import games.minesweeper.Minefield;
import games.minesweeper.field.state.Covered;
import games.minesweeper.field.state.FieldState;
import games.minesweeper.field.state.Flagged;
import games.minesweeper.field.state.Uncovered;
import games.minesweeper.field.value.FieldNumber;
import games.minesweeper.field.value.FieldValue;
import games.minesweeper.field.value.Mine;

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

	public void markHandle() {
		state = state.nextMarkedState();
	}

	public void chordHandle() {
		minefield.chordHandle(i, j);
	}

	public void incrementNeighbours() {
		minefield.incrementNeighbours(i, j);
	}
	
	public void incrementFlagCounter() {
		minefield.incrementFlagCounter();
	}

	public void decrementFlagCounter() {
		minefield.decrementFlagCounter();
	}

	public void gameOver() {
		minefield.gameOver();
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
