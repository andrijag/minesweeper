package main.java.games.minesweeper.model.minefield;

import main.java.games.minesweeper.model.util.Visitor;

class Unknown extends FieldState {
	Unknown(Field field) {
		super(field);
	}

	@Override
	void mark() {
		field.changeState(new Covered(field));
	}
	
	@Override
	void accept(Visitor visitor) {
		visitor.visitUnknownField();
	}

	@Override
	public String toString() {
		return "?";
	}
}
