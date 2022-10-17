package main.java.games.minesweeper.gamestate;

import main.java.games.minesweeper.Minesweeper;

public class WinnerState extends GameState {
	public WinnerState(Minesweeper game) {
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