package main.java.games.minesweeper.field;

abstract class FieldState {
	protected Field field;

	protected FieldState(Field field) {
		this.field = field;
	}

	abstract void mark();
}
