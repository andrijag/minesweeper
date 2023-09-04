package main.java.games.minesweeper.model;

abstract class GameState {
	protected Game game;

	protected GameState(Game game) {
		this.game = game;
	}

	void sweep(int row, int column) {
		game.getMinesweeper().sweep(game.getField(row, column));
		game.evaluate();
		game.notifyObservers();
	}

	void mark(int row, int column) {
		game.getMinesweeper().mark(game.getField(row, column));
		game.notifyObservers();
	}

	void chord(int row, int column) {
		game.getMinesweeper().chord(game.getField(row, column));
		game.evaluate();
		game.notifyObservers();
	}
}
