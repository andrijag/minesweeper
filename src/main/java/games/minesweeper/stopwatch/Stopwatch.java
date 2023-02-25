package main.java.games.minesweeper.stopwatch;

public class Stopwatch {
	private long startTime;
	private long elapsedTime;
	private StopwatchState state;

	public Stopwatch() {
		startTime = 0;
		elapsedTime = 0;
		state = new StoppedState(this);
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

	public void start() {
		state.start();
	}

	public void stop() {
		state.stop();
	}

	public void reset() {
		startTime = 0;
		elapsedTime = 0;
		state = new StoppedState(this);
	}

	public long getTime() {
		return state.getTime();
	}
}
