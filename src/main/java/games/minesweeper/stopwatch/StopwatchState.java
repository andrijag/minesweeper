package main.java.games.minesweeper.stopwatch;

public abstract class StopwatchState {
	protected Stopwatch stopwatch;

	public StopwatchState(Stopwatch stopwatch) {
		this.stopwatch = stopwatch;
	}

	public abstract void start();

	public abstract void stop();

	public abstract long getTime();
}
