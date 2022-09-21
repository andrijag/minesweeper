package games.minesweeper;

public class Playing extends GameState {
	public Playing(Minesweeper game) {
		super(game);
	}

	public void sweep(int i, int j) {
		game.getMinefield().sweep(i, j);
	}

	public void flag(int i, int j) {
		game.getMinefield().flag(i, j);
	}

	public void chord(int i, int j) {
		game.getMinefield().chord(i, j);
	}
}
