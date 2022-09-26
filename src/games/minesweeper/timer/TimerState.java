package games.minesweeper.timer;

public abstract class TimerState {
	protected Timer timer;
	
	public TimerState(Timer timer) {
		this.timer = timer;
	}
	
	public abstract void start();
	
	public abstract void stop();

	public abstract long getTime();
}
