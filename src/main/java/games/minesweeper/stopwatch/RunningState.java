package main.java.games.minesweeper.stopwatch;

class RunningState extends StopwatchState {
	RunningState(Stopwatch stopwatch) {
		super(stopwatch);
	}

	@Override
	void start() {
	}

	@Override
	void stop() {
		stopwatch.setElapsedTime(getTime());
		stopwatch.changeState(new StoppedState(stopwatch));
	}

	@Override
	long getTime() {
		return stopwatch.getElapsedTime() + System.currentTimeMillis() - stopwatch.getStartTime();
	}
}
