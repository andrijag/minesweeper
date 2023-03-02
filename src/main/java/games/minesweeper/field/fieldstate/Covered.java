package main.java.games.minesweeper.field.fieldstate;

import main.java.games.minesweeper.field.Field;

public class Covered extends FieldState {
	public Covered(Field field) {
		super(field);
	}

	@Override
	public void mark() {
		field.flag();
	}

	@Override
	public String toString() {
		return ".";
	}
}
