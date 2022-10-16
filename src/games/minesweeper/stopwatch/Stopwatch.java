package games.minesweeper.timer;

public class Timer {
	private long startTime;
	private long elapsedTime;
	private TimerState state;

	public Timer() {
		startTime = 0;
		elapsedTime = 0;
		state = new StoppedState(this);
	}

	public long getStartTime() {
		return startTime;
	}

	public long getElapsedTime() {
		return elapsedTime;
	}

	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}

	public void setElapsedTime(long elapsedTime) {
		this.elapsedTime = elapsedTime;
	}

	public void setState(TimerState state) {
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
