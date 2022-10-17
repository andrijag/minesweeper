package main.java.games.minesweeper.stopwatch;

public class StoppedState extends StopwatchState {
	public StoppedState(Stopwatch stopwatch) {
		super(stopwatch);
	}

	@Override
	public void start() {
		stopwatch.setStartTime(System.currentTimeMillis());
		stopwatch.setState(new RunningState(stopwatch));
	}

	@Override
	public void stop() {
	}

	@Override
	public long getTime() {
		return stopwatch.getElapsedTime();
	}
}
