package main.java.games.minesweeper.model;

class FirstMove extends GameState {
	FirstMove(Game game) {
		super(game);
	}

	@Override
	void sweep(int row, int column) {
		game.startTime();
		game.scatterMinesExcludingField(row, column);
		game.changeState(new Playing(game));
		super.sweep(row, column);
	}
}
