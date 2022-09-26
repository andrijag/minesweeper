package games.minesweeper.timer;

public class Running extends TimerState {
	public Running(Timer timer) {
		super(timer);
	}

	@Override
	public void start() {
	}

	@Override
	public void stop() {
		timer.setElapsedTime(timer.getElapsedTime() + System.currentTimeMillis() - timer.getStartTime());
		timer.setState(new Stopped(timer));
	}

	@Override
	public long getTime() {
		return System.currentTimeMillis() - timer.getStartTime();
	}
}
