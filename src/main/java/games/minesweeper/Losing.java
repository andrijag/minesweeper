package main.java.games.minesweeper;

public class Losing extends GameState {
	public Losing(Game game) {
		super(game);
	}

	@Override
	void sweep(int i, int j) {
	}

	@Override
	void mark(int i, int j) {
	}

	@Override
	void chord(int i, int j) {
	}
}
