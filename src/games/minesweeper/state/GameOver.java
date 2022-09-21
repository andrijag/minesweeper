package games.minesweeper.state;

import games.minesweeper.Minesweeper;

public class GameOver extends GameState {
	public GameOver(Minesweeper game) {
		super(game);
	}

	@Override
	public void sweep(int i, int j) {
	}

	@Override
	public void flag(int i, int j) {
	}

	@Override
	public void chord(int i, int j) {
	}
}
