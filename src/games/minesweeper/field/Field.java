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

	public FieldValue getValue() {
		return value;
	}

	private void setValue(FieldValue value) {
		this.value = value;
	}
	
	public void resetValue() {
		value.reset();
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
	
	public int adjecentMines() {
		return ((FieldNumber) value).getNumber();
	}

	public String toString() {
		return value.toString();
//		if (isUncovered()) {
//			return value.toString();
//		} else {
//			return state.toString();
//		}
	}
}
