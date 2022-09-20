package games.minesweeper.field;

import games.minesweeper.Minefield;
import games.minesweeper.field.state.Covered;
import games.minesweeper.field.state.FieldState;
import games.minesweeper.field.state.Flagged;
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
		value = new FieldNumber(0);
		state = new Covered(this);
	}

	public Minefield getMinefield() {
		return minefield;
	}

	public FieldValue getValue() {
		return value;
	}

	private void setValue(FieldValue value) {
		this.value = value;
	}

	private void setState(FieldState state) {
		this.state = state;
	}

	public void sweep() {
		state.sweep();
	}

	public void flag() {
		state.flag();
	}

	public void chord() {
		state.chord();
	}

	public void layMine() {
		setValue(new Mine());
	}

	public void uncover() {
		if (isMine()) {
			endGame();
		}
		setState(state.nextUncoveredState());
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

	public void flagHandle() {
		setState(state.nextFlaggedState());
	}

	public void chordHandle() {
		minefield.chordHandle(i, j);
	}

	public void incrementNeighbours() {
		minefield.incrementNeighbours(i, j);
	}

	public void endGame() {
		minefield.endGame();
	}

	public void incrementFlagCounter() {
		minefield.incrementFlagCounter();
	}

	public void decrementFlagCounter() {
		minefield.decrementFlagCounter();
	}

	@Override
	public String toString() {
		return state.toString();
	}
}
