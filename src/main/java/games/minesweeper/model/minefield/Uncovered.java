package main.java.games.minesweeper.model.minefield;

import main.java.games.minesweeper.model.util.Visitor;

class Uncovered extends FieldState {
	Uncovered(Field field) {
		super(field);
	}

	@Override
	void mark() {
	}
	
	@Override
	void accept(Visitor visitor) {
		field.getValue().accept(visitor);
	}

	@Override
	public String toString() {
		return field.getValue().toString();
	}
}
