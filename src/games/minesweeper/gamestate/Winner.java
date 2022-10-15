package games.minesweeper.gamestate;

import games.minesweeper.Minesweeper;

public class Winner extends GameState {
	public Winner(Minesweeper game) {
		super(game);
	}

	@Override
	public void sweep(int i, int j) {
	}

	@Override
	public void mark(int i, int j) {
	}

	@Override
	public void chord(int i, int j) {
	}
}
