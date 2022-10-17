package main.java.games.minesweeper.field.fieldstate;

import main.java.games.minesweeper.field.Field;

public class Covered extends FieldState {
	public Covered(Field field) {
		super(field);
	}

	@Override
	public void chord() {
	}

	@Override
	public void mark() {
		field.setState(new Flagged(field));
		field.incrementNumberOfFlags();
	}

	@Override
	public String toString() {
		return ".";
	}
}