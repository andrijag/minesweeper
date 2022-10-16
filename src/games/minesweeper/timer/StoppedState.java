package games.minesweeper.timer;

public class StoppedState extends TimerState {
	public StoppedState(Timer timer) {
		super(timer);
	}

	@Override
	public void start() {
		timer.setStartTime(System.currentTimeMillis());
		timer.setState(new RunningState(timer));

	}

	@Override
	public void stop() {
	}

	@Override
	public long getTime() {
		return timer.getElapsedTime();
	}
}
