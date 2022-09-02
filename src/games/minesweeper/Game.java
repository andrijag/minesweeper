package games.minesweeper;

public class Game {
	private int nRows;
	private int nColumns;
	private int nMines;
	private Minefield minefield;
	private Minelayer minelayer;
	private GameState state;

	public Game(int nRows, int nColumns, int nMines) {
		this.nRows = nRows;
		this.nColumns = nColumns;
		this.nMines = nMines;
		minefield = new Minefield(nRows, nColumns);
		minelayer = new Minelayer(minefield, nMines);
		state = new FirstMove(this);
	}

	public Minefield getMinefield() {
		return minefield;
	}

	public Minelayer getMinelayer() {
		return minelayer;
	}

	public void setState(GameState state) {
		this.state = state;
	}

	public void sweep(int i, int j) {
		state.sweep(i, j);
	}

	public void flag(int i, int j) {
		state.flag(i, j);
	}

	public void chord(int i, int j) {
		state.chord(i, j);
	}

	public void restart() {
		minefield = new Minefield(nRows, nColumns);
		minelayer = new Minelayer(minefield, nMines);
		state = new FirstMove(this);
	}

	@Override
	public String toString() {
		return minefield.toString();
	}
}
