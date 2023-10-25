package main.java.games.minesweeper.model.stopwatch;

abstract class StopwatchState {
	abstract void start(Stopwatch stopwatch);

	abstract void stop(Stopwatch stopwatch);

	abstract long readTimeInMillis(Stopwatch stopwatch);
}
