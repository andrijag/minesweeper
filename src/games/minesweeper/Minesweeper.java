package games.minesweeper;

import games.minesweeper.state.FirstMove;
import games.minesweeper.state.GameOver;
import games.minesweeper.state.GameState;

public class Minesweeper {
	private int nRows;
	private int nColumns;
	private int nMines;
	private int flagCounter;
	private Minefield minefield;
	private Minelayer minelayer;
	private GameState state;

	public Minesweeper(int nRows, int nColumns, int nMines) {
		this.nRows = nRows;
		this.nColumns = nColumns;
		this.nMines = nMines;
		flagCounter = 0;
		minefield = new Minefield(this, nRows, nColumns);
		minelayer = new Minelayer(minefield, nMines);
		state = new FirstMove(this);
	}

	public int getFlagCounter() {
		return flagCounter;
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
		flagCounter = 0;
		minefield = new Minefield(this, nRows, nColumns);
		minelayer = new Minelayer(minefield, nMines);
		state = new FirstMove(this);
	}

	public void incrementFlagCounter() {
		flagCounter++;
	}

	public void decrementFlagCounter() {
		flagCounter--;
	}

	public void endGame() {
		uncoverMines();
		state = new GameOver(this);
	}

	public void uncoverMines() {
		minefield.uncoverMines();
	}

	@Override
	public String toString() {
		return minefield.toString();
	}
}
