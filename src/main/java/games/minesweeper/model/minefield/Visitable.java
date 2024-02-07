package main.java.games.minesweeper.model.minefield;

interface Visitable {
	public void accept(Visitor visitor);
}
