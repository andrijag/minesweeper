package games.minesweeper;

public class Game {
	private Minefield minefield;
	private Minelayer minelayer;
	private Minesweeper minesweeper;

	public Game(int nRows, int nColumns, int nMines) {
		minefield = new Minefield(nRows, nColumns);
		minelayer = new Minelayer(minefield, nMines);
		minesweeper = new Minesweeper(minefield);
		minelayer.layMines();
	}

	public void sweep(int i, int j) {
		minesweeper.sweep(i, j);
	}

	public void flag(int i, int j) {
		minesweeper.flag(i, j);
	}

	public void chord(int i, int j) {
		minesweeper.chord(i, j);
	}

	@Override
	public String toString() {
		return minefield.toString();
	}
}
