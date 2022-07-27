package games.minesweeper.field;

import games.minesweeper.field.state.Covered;
import games.minesweeper.field.state.FieldState;
import games.minesweeper.field.value.FieldNumber;
import games.minesweeper.field.value.FieldValue;

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
}
