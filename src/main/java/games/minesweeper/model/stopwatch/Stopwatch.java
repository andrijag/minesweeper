package main.java.games.minesweeper.model.stopwatch;

public class Stopwatch {
	private long startTime;
	private long elapsedTime;
	private StopwatchState state = new StoppedState();

	public void start() {
		state.start(this);
	}

	public void stop() {
		state.stop(this);
	}

	public long readTimeInMillis() {
		return state.readTimeInMillis(this);
	}

	public void reset() {
		startTime = 0;
		elapsedTime = 0;
		state = new StoppedState();
	}

	long getStartTime() {
		return startTime;
	}

	void setStartTime(long startTime) {
		this.startTime = startTime;
	}

	long getElapsedTime() {
		return elapsedTime;
	}

	void setElapsedTime(long elapsedTime) {
		this.elapsedTime = elapsedTime;
	}

	void changeState(StopwatchState state) {
		this.state = state;
	}
}
