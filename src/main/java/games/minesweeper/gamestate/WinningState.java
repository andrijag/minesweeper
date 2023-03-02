package main.java.games.minesweeper.gamestate;

import main.java.games.minesweeper.Game;

public class WinningState extends GameState {
	public WinningState(Game game) {
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
