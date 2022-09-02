package games.minesweeper;

public abstract class GameState {
	protected Game game;

	public GameState(Game game) {
		this.game = game;
	}

	public abstract void sweep(int i, int j);
	
	public abstract void flag(int i, int j);

	public abstract void chord(int i, int j);
}
