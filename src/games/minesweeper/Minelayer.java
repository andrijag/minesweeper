package games.minesweeper;

public class Minelayer {
	Minefield minefield;
	int nMines;

	public Minelayer(Minefield minefield, int nMines) {
		this.minefield = minefield;
		this.nMines = nMines;
	}
}
