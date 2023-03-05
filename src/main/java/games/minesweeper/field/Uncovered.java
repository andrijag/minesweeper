package main.java.games.minesweeper.field;

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