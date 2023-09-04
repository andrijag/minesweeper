package main.java.games.minesweeper.model.stopwatch;

abstract class StopwatchState {
	protected Stopwatch stopwatch;

	protected StopwatchState(Stopwatch stopwatch) {
		this.stopwatch = stopwatch;
	}

	abstract void start();

	abstract void stop();

	abstract long readTimeInMillis();
}