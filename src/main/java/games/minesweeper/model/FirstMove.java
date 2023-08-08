package main.java.games.minesweeper.model;

class FirstMove extends GameState {
	FirstMove(Game game) {
		super(game);
	}

	@Override
	void sweep(int i, int j) {
		game.startTime();
		game.scatterMinesExcludingField(i, j);
		game.changeState(new Playing(game));
		super.sweep(i, j);
	}
}
