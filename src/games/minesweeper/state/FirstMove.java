package games.minesweeper.state;

import games.minesweeper.Minesweeper;

public class FirstMove extends GameState {
	public FirstMove(Minesweeper game) {
		super(game);
	}

	@Override
	public void sweep(int i, int j) {
		game.getMinelayer().remove(game.getMinefield().get(i, j));
		game.getMinelayer().layMines();
		game.getMinefield().sweep(i, j);
		game.setState(new Playing(game));
		game.validate();
	}

	@Override
	public void mark(int i, int j) {
		game.getMinefield().mark(i, j);
	}

	@Override
	public void chord(int i, int j) {
	}
}
