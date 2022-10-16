package main.java.games.minesweeper.gamestate;

import main.java.games.minesweeper.Minesweeper;

public class FirstMove extends GameState {
	public FirstMove(Minesweeper game) {
		super(game);
	}

	@Override
	public void sweep(int i, int j) {
		game.getTimer().start();
		game.getMinelayer().remove(game.getMinefield().get(i, j));
		game.getMinelayer().layMines();
		game.setState(new Playing(game));
		game.sweep(i, j);
		game.validate();
	}

	@Override
	public void mark(int i, int j) {
		game.getTimer().start();
		game.getMinefield().mark(i, j);
	}

	@Override
	public void chord(int i, int j) {
	}
}
