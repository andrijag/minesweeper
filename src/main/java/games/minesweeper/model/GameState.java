package main.java.games.minesweeper.model;

abstract class GameState {
	abstract void sweep(Game game, int row, int column);

	abstract void mark(Game game, int row, int column);

	abstract void chord(Game game, int row, int column);
}
