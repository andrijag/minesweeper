package main.java.games.minesweeper.gamestate;

import main.java.games.minesweeper.Minesweeper;

public class LosingState extends GameState {
	public LosingState(Minesweeper game) {
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
