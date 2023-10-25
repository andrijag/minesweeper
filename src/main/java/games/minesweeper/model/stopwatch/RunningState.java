package main.java.games.minesweeper.model.stopwatch;

class RunningState extends StopwatchState {
	@Override
	void start(Stopwatch stopwatch) {
	}

	@Override
	void stop(Stopwatch stopwatch) {
		stopwatch.setElapsedTime(readTimeInMillis(stopwatch));
		stopwatch.changeState(new StoppedState());
	}

	@Override
	long readTimeInMillis(Stopwatch stopwatch) {
		return stopwatch.getElapsedTime() + System.currentTimeMillis() - stopwatch.getStartTime();
	}
}
