package games.minesweeper;

public class Game {
	private int nRows;
	private int nColumns;
	private int nMines;
	private Minefield minefield;
	private Minelayer minelayer;

	public Game(int nRows, int nColumns, int nMines) {
		this.nRows = nRows;
		this.nColumns = nColumns;
		this.nMines = nMines;
		minefield = new Minefield(nRows, nColumns);
		minelayer = new Minelayer(minefield, nMines);
		minelayer.layMines();
	}

	public void sweep(int i, int j) {
		minefield.sweep(i, j);
	}

	public void flag(int i, int j) {
		minefield.flag(i, j);
	}

	public void chord(int i, int j) {
		minefield.chord(i, j);
	}

	public void restart() {
		minefield = new Minefield(nRows, nColumns);
		minelayer = new Minelayer(minefield, nMines);
		minelayer.layMines();
	}

	@Override
	public String toString() {
		return minefield.toString();
	}
}
