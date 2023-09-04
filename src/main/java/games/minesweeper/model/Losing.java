package main.java.games.minesweeper.model;

class Losing extends GameState {
	Losing(Game game) {
		super(game);
	}

	@Override
	void sweep(int row, int column) {
	}

	@Override
	void mark(int row, int column) {
	}

	@Override
	void chord(int row, int column) {
	}
}
