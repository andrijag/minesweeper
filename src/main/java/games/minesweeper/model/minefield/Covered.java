package main.java.games.minesweeper.model.minefield;

import main.java.games.minesweeper.model.util.Visitor;

class Covered extends FieldState {
	Covered(Field field) {
		super(field);
	}

	@Override
	void mark() {
		field.flag();
	}

	@Override
	void accept(Visitor visitor) {
		visitor.visitCoveredField();
	}

	@Override
	public String toString() {
		return ".";
	}
}
