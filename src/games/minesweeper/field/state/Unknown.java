package games.minesweeper.field.state;

import games.minesweeper.field.Field;

public class Unknown extends FieldState {
	public Unknown(Field field) {
		super(field);
	}
	
	@Override
	public void action() {
		field.sweep();
	}

	@Override
	public FieldState nextState1() {
		return new Uncovered(field);
	}

	@Override
	public FieldState nextState2() {
		return new Flagged(field);
	}

	@Override
	public String toString() {
		return "?";
	}
}
