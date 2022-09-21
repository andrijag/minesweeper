package games.minesweeper.state;

import games.minesweeper.Minesweeper;

public abstract class GameState {
	protected Minesweeper game;

	public GameState(Minesweeper game) {
		this.game = game;
	}

	public abstract void sweep(int i, int j);
	
	public abstract void flag(int i, int j);

	public abstract void chord(int i, int j);
}
