package main.java.games.minesweeper.model.minefield;

import main.java.games.minesweeper.model.util.Visitor;

class Flagged extends FieldState {
	private boolean isFalselyFlagged = false;

	Flagged(Field field) {
		super(field);
	}

	void setFalselyFlagged() {
		isFalselyFlagged = true;
	}

	@Override
	void mark() {
		field.changeState(new Unknown(field));
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
