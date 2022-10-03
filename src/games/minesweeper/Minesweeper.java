package games.minesweeper;

import games.minesweeper.state.FirstMove;
import games.minesweeper.state.GameOver;
import games.minesweeper.state.GameState;
import games.minesweeper.state.Winner;
import games.minesweeper.timer.Timer;

public class Minesweeper {
	private int nRows;
	private int nColumns;
	private int nMines;
	private int nFlags;
	private int toUncover;
	private Timer timer;
	private Minefield minefield;
	private Minelayer minelayer;
	private GameState state;

	public Minesweeper(int nRows, int nColumns, int nMines) {
		this.nRows = nRows;
		this.nColumns = nColumns;
		this.nMines = nMines;
		nFlags = 0;
		toUncover = nRows * nColumns - nMines;
		timer = new Timer();
		minefield = new Minefield(this, nRows, nColumns);
		minelayer = new Minelayer(minefield, nMines);
		state = new FirstMove(this);
	}

	public Timer getTimer() {
		return timer;
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

	public long getTime() {
		return timer.getTime();
	}

	public int getMinecount() {
		return nMines - nFlags;
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
		nFlags = 0;
		toUncover = nRows * nColumns - nMines;
		timer.reset();
		minefield = new Minefield(this, nRows, nColumns);
		minelayer = new Minelayer(minefield, nMines);
		state = new FirstMove(this);
	}

	public void incrementNFlags() {
		nFlags++;
	}

	public void decrementNFlags() {
		nFlags--;
	}

	public void gameOver() {
		timer.stop();
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
		if (allUncovered()) {
			youWin();
		}
	}

	private boolean allUncovered() {
		return toUncover == 0;
	}

	private void youWin() {
		timer.stop();
		flagMines();
		state = new Winner(this);
	}

	private void flagMines() {
		minefield.flagMines();
	}

	@Override
	public String toString() {
		return minefield.toString() + getMinecount();
	}
}
