package main.java.games.minesweeper;

import main.java.games.minesweeper.gamestate.FirstMove;
import main.java.games.minesweeper.gamestate.GameOver;
import main.java.games.minesweeper.gamestate.GameState;
import main.java.games.minesweeper.gamestate.Winner;
import main.java.games.minesweeper.stopwatch.Stopwatch;

public class Minesweeper {
	private int nRows;
	private int nColumns;
	private int nMines;
	private int toUncover;
	private Stopwatch stopwatch;
	private Minefield minefield;
	private Minelayer minelayer;
	private GameState state;

	public Minesweeper(int nRows, int nColumns, int nMines) {
		this.nRows = nRows;
		this.nColumns = nColumns;
		this.nMines = nMines;
		toUncover = nRows * nColumns - nMines;
		stopwatch = new Stopwatch();
		minefield = new Minefield(this, nRows, nColumns);
		minelayer = new Minelayer(minefield, nMines);
		state = new FirstMove(this);
	}

	public Stopwatch getTimer() {
		return stopwatch;
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
	
	public int getNFlags() {
		return minefield.getNFlags();
	}

	public long getTime() {
		return stopwatch.getTime();
	}

	public int getMinecount() {
		return nMines - getNFlags();
	}

	public void sweep(int i, int j) {
		state.sweep(i, j);
	}

	public void mark(int i, int j) {
		state.mark(i, j);
	}

	public void chord(int i, int j) {
		state.chord(i, j);
	}

	public void restart() {
		toUncover = nRows * nColumns - nMines;
		stopwatch.reset();
		minefield = new Minefield(this, nRows, nColumns);
		minelayer = new Minelayer(minefield, nMines);
		state = new FirstMove(this);
	}

	public void gameOver() {
		stopwatch.stop();
		uncoverMines();
		state = new GameOver(this);
	}

	private void uncoverMines() {
		minefield.uncoverMines();
	}

	public void decrementToUncover() {
		toUncover--;
	}

	public void validate() {
		if (allUncovered())
			youWin();
	}

	private boolean allUncovered() {
		return toUncover == 0;
	}

	private void youWin() {
		stopwatch.stop();
		flagMines();
		state = new Winner(this);
	}

	private void flagMines() {
		minefield.flagMines();
	}

	@Override
	public String toString() {
		return getMinecount() + "\t" + getTime() + "\n" + minefield.toString();
	}
}
