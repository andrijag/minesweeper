package main.java.games.minesweeper.model;

class FirstMove extends GameState {
	@Override
	void sweep(Game game, int row, int column) {
		game.startTime();
		game.scatterMinesExcludingField(row, column);
		game.changeState(new Playing());
		game.sweep(row, column);
	}

	@Override
	void mark(Game game, int row, int column) {
		game.getMinesweeper().mark(game.getField(row, column));
		game.notifyObservers();
	}

	@Override
	void chord(Game game, int row, int column) {
	}
}
