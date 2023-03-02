package main.java.games.minesweeper.gamestate;

import main.java.games.minesweeper.Game;

public class PlayingState extends GameState {
	public PlayingState(Game game) {
		super(game);
	}

	@Override
	public void sweep(int i, int j) {
		game.getMinefield().sweep(i, j);
		game.evaluate();
	}

	@Override
	public void mark(int i, int j) {
		game.getMinefield().mark(i, j);
	}

	@Override
	public void chord(int i, int j) {
		game.getMinefield().chord(i, j);
		game.evaluate();
	}
}
