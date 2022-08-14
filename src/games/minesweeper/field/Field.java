package games.minesweeper.field;

import games.minesweeper.field.state.Covered;
import games.minesweeper.field.state.FieldState;
import games.minesweeper.field.state.Flagged;
import games.minesweeper.field.state.Uncovered;
import games.minesweeper.field.value.FieldNumber;
import games.minesweeper.field.value.FieldValue;
import games.minesweeper.field.value.Mine;

public class Field {
	private FieldValue value;
	private FieldState state;

	public Field() {
		value = new FieldNumber(0);
		state = new Covered(this);
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

	public void layMine() {
		setValue(new Mine());
	}

	public int getNumber() {
		return ((FieldNumber) value).getNumber();
	}

	public void increment() {
		((FieldNumber) value).increment();
	}

	public void uncover() {
		setState(state.nextState1());
	}

	public void flag() {
		setState(state.nextState2());
	}

	public boolean isMine() {
		return value instanceof Mine;
	}

	public boolean isUncovered() {
		return state instanceof Uncovered;
	}

	public boolean isFlagged() {
		return state instanceof Flagged;
	}

	@Override
	public String toString() {
		return state.toString();
	}
}
