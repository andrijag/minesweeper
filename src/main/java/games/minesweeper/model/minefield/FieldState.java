package main.java.games.minesweeper.model.minefield;

abstract class FieldState {
	abstract void mark(Field field);
	
	abstract void accept(Visitor visitor);
}
