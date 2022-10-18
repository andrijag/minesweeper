package games.minesweeper.timer;

public class RunningState extends TimerState {
	public RunningState(Timer timer) {
		super(timer);
	}

	@Override
	public void start() {
	}

	@Override
	public void stop() {
		timer.setElapsedTime(timer.getElapsedTime() + System.currentTimeMillis() - timer.getStartTime());
		timer.setState(new StoppedState(timer));
	}

	@Override
	public long getTime() {
		return timer.getElapsedTime() + System.currentTimeMillis() - timer.getStartTime();
	}
}
