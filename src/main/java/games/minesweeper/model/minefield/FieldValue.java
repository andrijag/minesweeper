package main.java.games.minesweeper.model.minefield;

import main.java.games.minesweeper.model.util.Visitor;

abstract class FieldValue {
	abstract void accept(Visitor visitor);
}
