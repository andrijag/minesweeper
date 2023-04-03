package main.java.games.minesweeper;

abstract class GameState {
	protected Game game;

	protected GameState(Game game) {
		this.game = game;
	}

	abstract void sweep(int i, int j);

	abstract void mark(int i, int j);

	abstract void chord(int i, int j);
}
