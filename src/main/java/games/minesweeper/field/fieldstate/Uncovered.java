package main.java.games.minesweeper.field.fieldstate;

import main.java.games.minesweeper.field.Field;

public class Uncovered extends FieldState {
	public Uncovered(Field field) {
		super(field);
	}

	@Override
	public void mark() {
	}

	@Override
	public String toString() {
		return field.getValue().toString();
	}
}
