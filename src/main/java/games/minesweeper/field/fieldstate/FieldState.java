package main.java.games.minesweeper.field.fieldstate;

import main.java.games.minesweeper.field.Field;

public abstract class FieldState {
	protected Field field;

	public FieldState(Field field) {
		this.field = field;
	}

	public abstract void mark();
}
