package games.minesweeper.field;

import games.minesweeper.field.state.Covered;
import games.minesweeper.field.state.FieldState;
import games.minesweeper.field.state.Uncovered;
import games.minesweeper.field.value.FieldNumber;
import games.minesweeper.field.value.FieldValue;
import games.minesweeper.field.value.Mine;

public class Field {
	FieldValue value;
	FieldState state;

	public Field() {
		value = new FieldNumber(0);
		state = new Covered();
	}

	public FieldValue getValue() {
		return value;
	}

	private void setValue(FieldValue value) {
		this.value = value;
	}

	public FieldState getState() {
		return state;
	}

	private void setState(FieldState state) {
		this.state = state;
	}

	public void layMine() {
		setValue(new Mine());
	}

	public void increment() {
		value.increment();
	}

	public void uncover() {
		setState(state.nextPrimaryState());
	}

	public void flag() {
		setState(state.nextSecondaryState());
	}

	public boolean isMine() {
		return value instanceof Mine;
	}

	public boolean isUncovered() {
		return state instanceof Uncovered;
	}

	public String toString() {
		return value.toString();
	}
}
