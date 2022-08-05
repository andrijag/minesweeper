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
		state = new Covered();
	}

	private void setValue(FieldValue value) {
		this.value = value;
	}

	private void setState(FieldState state) {
		this.state = state;
	}
	
	public Integer getNumber() {
		return value.getNumber();
	}

	public void layMine() {
		setValue(new Mine());
	}
	
	public void resetValue() {
		value.reset();
	}

	public void increment() {
		value.increment();
	}

	public void uncover() {
		setState(state.nextState1());
	}

	public void flag() {
		setState(state.nextState2());
	}
	
	public boolean equals(int number) {
		return value.equals(number);
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

	public String toString() {
//		return value.toString();
		if (isUncovered()) {
			return value.toString();
		} else {
			return state.toString();
		}
	}
}
