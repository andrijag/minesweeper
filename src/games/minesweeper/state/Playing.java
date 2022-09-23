package games.minesweeper.state;

import games.minesweeper.Minesweeper;

public class Playing extends GameState {
	public Playing(Minesweeper game) {
		super(game);
	}

	@Override
	public void sweep(int i, int j) {
		game.getMinefield().sweep(i, j);
	}

	@Override
	public void mark(int i, int j) {
		game.getMinefield().mark(i, j);
	}

	@Override
	public void chord(int i, int j) {
		game.getMinefield().chord(i, j);
	}
}
