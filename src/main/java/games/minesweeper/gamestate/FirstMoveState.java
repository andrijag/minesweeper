package main.java.games.minesweeper.gamestate;

import main.java.games.minesweeper.Minesweeper;

public class FirstMoveState extends GameState {
	public FirstMoveState(Minesweeper game) {
		super(game);
	}

	@Override
	public void sweep(int i, int j) {
		game.getStopwatch().start();
		game.getMinelayer().remove(game.getMinefield().getField(i, j));
		game.getMinelayer().scatterMines();
		game.changeState(new PlayingState(game));
		game.sweep(i, j);
	}

	@Override
	public void mark(int i, int j) {
		game.getStopwatch().start();
		game.getMinefield().mark(i, j);
	}

	@Override
	public void chord(int i, int j) {
	}
}
