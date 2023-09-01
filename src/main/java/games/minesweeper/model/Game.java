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

	public Field getField(int i, int j) {
		return minefield.getField(i, j);
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

	void scatterMinesExcludingField(int i, int j) {
		minelayer.remove(minefield.getField(i, j));
		minelayer.scatterMines(numberOfMines);
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
