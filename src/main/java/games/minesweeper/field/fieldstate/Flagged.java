package main.java.games.minesweeper.field.fieldstate;

import main.java.games.minesweeper.field.Field;

public class Flagged extends FieldState {
	public Flagged(Field field) {
		super(field);
	}

	@Override
	public void sweep() {
	}

	@Override
	public void chord() {
	}

	@Override
	public void mark() {
		field.setState(new Unknown(field));
		field.getMinefield().decrementNumberOfFlags();
	}

	@Override
	public String toString() {
		return ">";
	}
}
