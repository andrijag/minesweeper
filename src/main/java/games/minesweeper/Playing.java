package main.java.games.minesweeper;

public class Playing extends GameState {
	public Playing(Game game) {
		super(game);
	}

	@Override
	void sweep(int i, int j) {
		game.getMinesweeper().sweep(game.getField(i, j));
		game.evaluate();
		game.notifyObservers();
	}

	@Override
	void mark(int i, int j) {
		game.getMinesweeper().mark(game.getField(i, j));
		game.notifyObservers();
	}

	@Override
	void chord(int i, int j) {
		game.getMinesweeper().chord(game.getField(i, j));
		game.evaluate();
		game.notifyObservers();
	}
}
