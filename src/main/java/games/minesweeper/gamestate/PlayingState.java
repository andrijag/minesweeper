package main.java.games.minesweeper.gamestate;

import main.java.games.minesweeper.Game;

public class PlayingState extends GameState {
	public PlayingState(Game game) {
		super(game);
	}

	@Override
	public void sweep(int i, int j) {
		game.getMinesweeper().sweep(game.getMinefield().getField(i, j));
		game.evaluate();
	}

	@Override
	public void mark(int i, int j) {
		game.getMinesweeper().mark(game.getMinefield().getField(i, j));
	}

	@Override
	public void chord(int i, int j) {
		game.getMinesweeper().chord(game.getMinefield().getField(i, j));
		game.evaluate();
	}
}
