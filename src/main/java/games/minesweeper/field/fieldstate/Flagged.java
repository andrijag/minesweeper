package main.java.games.minesweeper.field.fieldstate;

import main.java.games.minesweeper.field.Field;

public class Flagged extends FieldState {
	public Flagged(Field field) {
		super(field);
	}

	@Override
	public void mark() {
		field.changeState(new Unknown(field));
	}

	@Override
	public String toString() {
		return ">";
	}
}
