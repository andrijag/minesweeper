package main.java.games.minesweeper.model.game;

abstract class GameState {
	protected Game game;

	protected GameState(Game game) {
		this.game = game;
	}

	void sweep(int i, int j) {
		game.getMinesweeper().sweep(game.getField(i, j));
		game.evaluate();
		game.notifyObservers();
	}

	void mark(int i, int j) {
		game.getMinesweeper().mark(game.getField(i, j));
		game.notifyObservers();
	}

	void chord(int i, int j) {
		game.getMinesweeper().chord(game.getField(i, j));
		game.evaluate();
		game.notifyObservers();
	}
}
