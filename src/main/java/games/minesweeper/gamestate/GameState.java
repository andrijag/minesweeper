package main.java.games.minesweeper.gamestate;

import main.java.games.minesweeper.Game;

public abstract class GameState {
	protected Game game;

	public GameState(Game game) {
		this.game = game;
	}

	public abstract void sweep(int i, int j);
	
	public abstract void mark(int i, int j);

	public abstract void chord(int i, int j);
}
