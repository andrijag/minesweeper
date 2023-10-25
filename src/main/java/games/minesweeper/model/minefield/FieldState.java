package main.java.games.minesweeper.model.minefield;

import main.java.games.minesweeper.model.util.Visitor;

abstract class FieldState {
	abstract void mark(Field field);
	
	abstract void accept(Visitor visitor);
}
