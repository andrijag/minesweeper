package main.java.games.minesweeper;

import main.java.games.minesweeper.minefield.Minefield;
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
		state = GameState.FIRST_MOVE;
	}

	public int getMinecount() {
		return numberOfMines - minefield.getNumberOfFlags();
	}

	public long getTime() {
		return stopwatch.getTime();
	}

	public Minefield getMinefield() {
		return minefield;
	}

	public void sweep(int i, int j) {
		if (state == GameState.PLAYING) {
			minesweeper.sweep(minefield.getField(i, j));
			evaluate();
		} else if (state == GameState.FIRST_MOVE) {
			stopwatch.start();
			minelayer.remove(minefield.getField(i, j));
			minelayer.scatterMines(numberOfMines);
			state = GameState.PLAYING;
			sweep(i, j);
		}
	}

	public void mark(int i, int j) {
		if (state == GameState.PLAYING)
			minesweeper.mark(minefield.getField(i, j));
		else if (state == GameState.FIRST_MOVE)
			stopwatch.start();
	}

	public void chord(int i, int j) {
		if (state == GameState.PLAYING) {
			minesweeper.chord(minefield.getField(i, j));
			evaluate();
		}
	}

	public void restart() {
		stopwatch.reset();
		minefield = new Minefield(numberOfRows, numberOfColumns);
		minelayer = new Minelayer(minefield);
		minesweeper = new Minesweeper(minefield);
		state = GameState.FIRST_MOVE;
	}

	private void evaluate() {
		if (minefield.isDetonated())
			youLose();
		else if (minefield.isCleared())
			youWin();
	}

	private void youLose() {
		stopwatch.stop();
		minefield.uncoverMines();
		state = GameState.LOSING;
	}

	private void youWin() {
		stopwatch.stop();
		minefield.flagMines();
		state = GameState.WINNING;
	}

	@Override
	public String toString() {
		return getMinecount() + "\t" + getTime() + "\n" + minefield.toString();
	}
}
