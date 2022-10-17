package main.java.games.minesweeper.gamestate;

import main.java.games.minesweeper.Minesweeper;

public class PlayingState extends GameState {
	public PlayingState(Minesweeper game) {
		super(game);
	}

	@Override
	public void sweep(int i, int j) {
		game.getMinefield().sweep(i, j);
		game.validate();
	}

	@Override
	public void mark(int i, int j) {
		game.getMinefield().mark(i, j);
	}

	@Override
	public void chord(int i, int j) {
		game.getMinefield().chord(i, j);
		game.validate();
	}
}