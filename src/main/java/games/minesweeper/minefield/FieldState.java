package main.java.games.minesweeper.minefield;

abstract class FieldState {
	protected Field field;

	protected FieldState(Field field) {
		this.field = field;
	}

	abstract void mark();
}
