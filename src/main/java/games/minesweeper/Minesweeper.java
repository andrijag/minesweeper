package main.java.games.minesweeper;

import main.java.games.minesweeper.gamestate.FirstMoveState;
import main.java.games.minesweeper.gamestate.GameOverState;
import main.java.games.minesweeper.gamestate.GameState;
import main.java.games.minesweeper.gamestate.WinnerState;
import main.java.games.minesweeper.stopwatch.Stopwatch;

public class Minesweeper {
	private int numberOfRows;
	private int numberOfColumns;
	private int numberOfMines;
	private int toUncover;
	private Stopwatch stopwatch;
	private Minefield minefield;
	private Minelayer minelayer;
	private GameState state;

	public Minesweeper(int numberOfRows, int numberOfColumns, int numberOfMines) {
		this.numberOfRows = numberOfRows;
		this.numberOfColumns = numberOfColumns;
		this.numberOfMines = numberOfMines;
		toUncover = numberOfRows * numberOfColumns - numberOfMines;
		stopwatch = new Stopwatch();
		minefield = new Minefield(numberOfRows, numberOfColumns);
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

	public int getNumberOfFlags() {
		return minefield.getNumberOfFlags();
	}

	public long getTime() {
		return stopwatch.getTime();
	}

	public int getMinecount() {
		return numberOfMines - getNumberOfFlags();
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
		toUncover = numberOfRows * numberOfColumns - numberOfMines;
		stopwatch.reset();
		minefield = new Minefield(numberOfRows, numberOfColumns);
		minelayer = new Minelayer(minefield, numberOfMines);
		state = new FirstMoveState(this);
	}

	public void gameOver() {
		stopwatch.stop();
		uncoverMines();
		state = new GameOverState(this);
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
		state = new WinnerState(this);
	}

	private void flagMines() {
		minefield.flagMines();
	}

	@Override
	public String toString() {
		return getMinecount() + "\t" + getTime() + "\n" + minefield.toString();
	}
}
