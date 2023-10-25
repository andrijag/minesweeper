package main.java.games.minesweeper.model.stopwatch;

class StoppedState extends StopwatchState {
	@Override
	void start(Stopwatch stopwatch) {
		stopwatch.setStartTime(System.currentTimeMillis());
		stopwatch.changeState(new RunningState());
	}

	@Override
	void stop(Stopwatch stopwatch) {
	}

	@Override
	long readTimeInMillis(Stopwatch stopwatch) {
		return stopwatch.getElapsedTime();
	}
}
