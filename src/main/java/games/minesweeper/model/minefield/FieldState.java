package main.java.games.minesweeper.model.minefield;

import main.java.games.minesweeper.model.util.Visitor;

abstract class FieldState {
	protected Field field;

	protected FieldState(Field field) {
		this.field = field;
	}

	abstract void mark();
	
	abstract void accept(Visitor visitor);
}
