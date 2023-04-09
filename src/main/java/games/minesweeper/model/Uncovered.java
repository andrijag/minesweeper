package main.java.games.minesweeper.model;

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
