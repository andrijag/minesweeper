package main.java.games.minesweeper.model;

class Playing extends GameState {
	@Override
	void sweep(Game game, int row, int column) {
		game.getMinesweeper().sweep(game.getField(row, column));
		game.evaluate();
		game.notifyObservers();
	}

	@Override
	void mark(Game game, int row, int column) {
		game.getMinesweeper().mark(game.getField(row, column));
		game.notifyObservers();
	}

	@Override
	void chord(Game game, int row, int column) {
		game.getMinesweeper().chord(game.getField(row, column));
		game.evaluate();
		game.notifyObservers();
	}

}
