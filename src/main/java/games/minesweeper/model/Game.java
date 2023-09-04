package main.java.games.minesweeper.model;

import main.java.games.minesweeper.model.minefield.Field;
import main.java.games.minesweeper.model.minefield.Minefield;
import main.java.games.minesweeper.model.minefield.Minelayer;
import main.java.games.minesweeper.model.minefield.Minesweeper;
import main.java.games.minesweeper.model.stopwatch.Stopwatch;
import main.java.games.minesweeper.model.util.Observable;

public class Game extends Observable {
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
		minesweeper = new Minesweeper();
		state = new FirstMove(this);
	}

	public int getMinecount() {
		return numberOfMines - minefield.getNumberOfFlags();
	}

	public long getTime() {
		return stopwatch.readTimeInMillis();
	}

	public Field getField(int row, int column) {
		return minefield.getField(row, column);
	}
	
	public int getNumberOfRows() {
		return numberOfRows;
	}
	
	public int getNumberOfColumns() {
		return numberOfColumns;
	}

	Minesweeper getMinesweeper() {
		return minesweeper;
	}

	void changeState(GameState state) {
		this.state = state;
	}

	void startTime() {
		stopwatch.start();
	}

	void scatterMinesExcludingField(int row, int column) {
		minelayer.remove(minefield.getField(row, column));
		minelayer.scatterMines(numberOfMines);
	}

	public void sweep(int row, int column) {
		state.sweep(row, column);
	}

	public void mark(int row, int column) {
		state.mark(row, column);
	}

	public void chord(int row, int column) {
		state.chord(row, column);
	}

	public void restart() {
		stopwatch.reset();
		minefield = new Minefield(numberOfRows, numberOfColumns);
		minelayer = new Minelayer(minefield);
		minesweeper = new Minesweeper();
		state = new FirstMove(this);
		notifyObservers();
	}

	void evaluate() {
		if (minefield.isDetonated())
			youLose();
		else if (minefield.isCleared())
			youWin();
	}

	private void youLose() {
		stopwatch.stop();
		minefield.uncoverMines();
		minefield.checkFlags();
		state = new Losing(this);
	}

	private void youWin() {
		stopwatch.stop();
		minefield.flagMines();
		state = new Winning(this);
	}

	public boolean isOver() {
		return isLost() || isWon();
	}

	public boolean isLost() {
		return state instanceof Losing;
	}

	public boolean isWon() {
		return state instanceof Winning;
	}

	@Override
	public String toString() {
		return getMinecount() + "\t" + getTime() + "\n" + minefield.toString();
	}
}
