package main.java.games.minesweeper.field.fieldstate;

import main.java.games.minesweeper.field.Field;

public class Unknown extends FieldState {
	public Unknown(Field field) {
		super(field);
	}

	@Override
	public void mark() {
		field.changeState(new Covered(field));
	}

	@Override
	public String toString() {
		return "?";
	}
}
