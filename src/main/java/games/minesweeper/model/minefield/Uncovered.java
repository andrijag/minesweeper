package main.java.games.minesweeper.model.minefield;

import main.java.games.minesweeper.model.util.Visitor;

class Uncovered extends FieldState {
	private FieldValue value;

	Uncovered(FieldValue value) {
		this.value = value;
	}

	@Override
	void mark(Field field) {
	}

	@Override
	void accept(Visitor visitor) {
		value.accept(visitor);
	}

	@Override
	public String toString() {
		return value.toString();
	}
}
