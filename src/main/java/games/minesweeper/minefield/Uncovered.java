package main.java.games.minesweeper.minefield;

class Uncovered extends FieldState {
	Uncovered(Field field) {
		super(field);
	}

	@Override
	void mark() {
	}

	@Override
	public String toString() {
		return field.getValue().toString();
	}
}
