package games.minesweeper;

public class Minesweeper {
	private Minefield minefield;

	public Minesweeper(Minefield minefield) {
		this.minefield = minefield;
	}

	public void sweep(int i, int j) {
		minefield.sweep(i, j);
	}

	public void flag(int i, int j) {
		minefield.flag(i, j);
	}
}
