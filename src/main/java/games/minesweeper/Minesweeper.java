package main.java.games.minesweeper;

import main.java.games.minesweeper.gamestate.FirstMoveState;
import main.java.games.minesweeper.gamestate.LoserState;
import main.java.games.minesweeper.gamestate.GameState;
import main.java.games.minesweeper.gamestate.WinnerState;
import main.java.games.minesweeper.stopwatch.Stopwatch;

public class Minesweeper {
	private int numberOfRows;
	private int numberOfColumns;
	private int numberOfMines;
	private Stopwatch stopwatch;
	private Minefield minefield;
	private Minelayer minelayer;
	private GameState state;

	public Minesweeper(int numberOfRows, int numberOfColumns, int numberOfMines) {
		this.numberOfRows = numberOfRows;
		this.numberOfColumns = numberOfColumns;
		this.numberOfMines = numberOfMines;
		stopwatch = new Stopwatch();
		minefield = new Minefield(numberOfRows, numberOfColumns, numberOfMines);
		minelayer = new Minelayer(minefield, numberOfMines);
		state = new FirstMoveState(this);
	}

	public Stopwatch getStopwatch() {
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

	public int getMinecount() {
		return numberOfMines - minefield.getNumberOfFlags();
	}

	public long getTime() {
		return stopwatch.getTime();
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
		stopwatch.reset();
		minefield = new Minefield(numberOfRows, numberOfColumns, numberOfMines);
		minelayer = new Minelayer(minefield, numberOfMines);
		state = new FirstMoveState(this);
	}

	public void validate() {
		if (minefield.isDetonated())
			youLose();
		else if (minefield.isCleared())
			youWin();
	}

	private void youLose() {
		stopwatch.stop();
		minefield.uncoverMines();
		state = new LoserState(this);
	}

	private void youWin() {
		stopwatch.stop();
		minefield.flagMines();
		state = new WinnerState(this);
	}

	@Override
	public String toString() {
		return getMinecount() + "\t" + getTime() + "\n" + minefield.toString();
	}
}
