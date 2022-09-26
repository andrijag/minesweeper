package games.minesweeper.timer;

public class Stopped extends TimerState {
	public Stopped(Timer timer) {
		super(timer);
	}

	@Override
	public void start() {
		timer.setStartTime(System.currentTimeMillis());
		timer.setState(new Running(timer));

	}

	@Override
	public void stop() {
	}

	@Override
	public long getTime() {
		return timer.getElapsedTime();
	}
}
