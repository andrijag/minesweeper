package main.java.games.minesweeper.model.minefield;

abstract class FieldValue {
	abstract void accept(Visitor visitor);
}
