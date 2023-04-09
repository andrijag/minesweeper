package main.java.games.minesweeper.stopwatch;

class StoppedState extends StopwatchState {
	StoppedState(Stopwatch stopwatch) {
		super(stopwatch);
	}

	@Override
	void start() {
		stopwatch.setStartTime(System.currentTimeMillis());
		stopwatch.changeState(new RunningState(stopwatch));
	}

	@Override
	void stop() {
	}

	@Override
	long readTimeInMillis() {
		return stopwatch.getElapsedTime();
	}
}
