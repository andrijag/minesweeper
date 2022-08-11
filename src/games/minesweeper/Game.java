package games.minesweeper;

public class Game {
	private Minefield minefield;
	private Minelayer minelayer;
	private Minesweeper minesweeper;

	public Game(int nRows, int nColumns, int nMines) {
		minefield = new Minefield(nRows, nColumns);
		minelayer = new Minelayer(minefield, nMines);
		minesweeper = new Minesweeper(minefield);
	}
}
