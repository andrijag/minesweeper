package games.minesweeper.field.state;

import games.minesweeper.field.Field;

public class Flagged extends FieldState {
	public Flagged(Field field) {
		super(field);
	}

	@Override
	public FieldState nextState1() {
		return new Flagged(field);
	}

	@Override
	public FieldState nextState2() {
		return new Unknown(field);
	}

	@Override
	public String toString() {
		return ">";
	}
}
