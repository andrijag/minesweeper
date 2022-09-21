package games.minesweeper;

public class FirstMove extends GameState {
	public FirstMove(Minesweeper game) {
		super(game);
	}

	public void sweep(int i, int j) {
		game.getMinelayer().remove(game.getMinefield().get(i, j));
		game.getMinelayer().layMines();
		game.getMinefield().sweep(i, j);
		game.setState(new Playing(game));
	}

	public void flag(int i, int j) {
		game.getMinefield().flag(i, j);
	}

	public void chord(int i, int j) {
	}
}
