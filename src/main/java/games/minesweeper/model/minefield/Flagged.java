package main.java.games.minesweeper.model.minefield;

import main.java.games.minesweeper.model.util.Visitor;

class Flagged extends FieldState {
	private boolean isFalselyFlagged = false;

	void setFalselyFlagged() {
		isFalselyFlagged = true;
	}

	@Override
	void mark(Field field) {
		field.changeState(new Unknown());
	}

	@Override
	void accept(Visitor visitor) {
		visitor.visitFlaggedField(isFalselyFlagged);
	}

	@Override
	public String toString() {
		return ">";
	}
}
