package main.java.games.minesweeper.stopwatch;

public class RunningState extends StopwatchState {
	public RunningState(Stopwatch timer) {
		super(timer);
	}

	@Override
	public void start() {
	}

	@Override
	public void stop() {
		stopwatch.setElapsedTime(stopwatch.getElapsedTime() + System.currentTimeMillis() - stopwatch.getStartTime());
		stopwatch.setState(new StoppedState(stopwatch));
	}

	@Override
	public long getTime() {
		return stopwatch.getElapsedTime() + System.currentTimeMillis() - stopwatch.getStartTime();
	}
}
