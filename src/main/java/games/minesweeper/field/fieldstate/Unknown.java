package main.java.games.minesweeper.field.fieldstate;

import main.java.games.minesweeper.field.Field;

public class Unknown extends FieldState {
	public Unknown(Field field) {
		super(field);
	}

	@Override
	public void mark() {
		field.setState(new Covered(field));
	}

	@Override
	public void chord() {
	}

	@Override
	public String toString() {
		return "?";
	}
}
