package main.java.games.minesweeper;

public class FirstMove extends GameState {
	public FirstMove(Game game) {
		super(game);
	}

	@Override
	void sweep(int i, int j) {
		game.startTime();
		game.scatterMinesExcludingField(i, j);
		game.changeState(new Playing(game));
		game.sweep(i, j);
	}

	@Override
	void mark(int i, int j) {
		game.startTime();
		game.getMinesweeper().mark(game.getMinefield().getField(i, j));
		game.notifyObservers();
	}

	@Override
	void chord(int i, int j) {
	}
}
