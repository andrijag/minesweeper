package main.java.games.minesweeper;

import main.java.games.minesweeper.gamestate.FirstMoveState;
import main.java.games.minesweeper.gamestate.LosingState;
import main.java.games.minesweeper.gamestate.GameState;
import main.java.games.minesweeper.gamestate.WinningState;
import main.java.games.minesweeper.stopwatch.Stopwatch;
import main.java.games.minesweeper.utils.Subject;

public class Game extends Subject {
	private int numberOfRows;
	private int numberOfColumns;
	private int numberOfMines;
	private Stopwatch stopwatch;
	private Minefield minefield;
	private Minelayer minelayer;
	private Minesweeper minesweeper;
	private GameState state;

	public Game(int numberOfRows, int numberOfColumns, int numberOfMines) {
		this.numberOfRows = numberOfRows;
		this.numberOfColumns = numberOfColumns;
		this.numberOfMines = numberOfMines;
		stopwatch = new Stopwatch();
		minefield = new Minefield(numberOfRows, numberOfColumns);
		minelayer = new Minelayer(minefield);
		minesweeper = new Minesweeper(minefield);
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
	
	public Minesweeper getMinesweeper() {
		return minesweeper;
	}
	
	public int getNumberOfMines() {
		return numberOfMines;
	}

	public void changeState(GameState state) {
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
		minefield = new Minefield(numberOfRows, numberOfColumns);
		minelayer = new Minelayer(minefield);
		minesweeper = new Minesweeper(minefield);
		state = new FirstMoveState(this);
	}

	public void evaluate() {
		if (minefield.isDetonated())
			youLose();
		else if (minefield.isCleared())
			youWin();
	}

	private void youLose() {
		stopwatch.stop();
		minefield.uncoverMines();
		state = new LosingState(this);
	}

	private void youWin() {
		stopwatch.stop();
		minefield.flagMines();
		state = new WinningState(this);
	}

	@Override
	public String toString() {
		return getMinecount() + "\t" + getTime() + "\n" + minefield.toString();
	}
}
